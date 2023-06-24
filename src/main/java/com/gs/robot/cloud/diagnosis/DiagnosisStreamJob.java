package com.gs.robot.cloud.diagnosis;

import com.gs.robot.cloud.diagnosis.config.PropertiesHelper;
import com.gs.robot.cloud.diagnosis.entity.IncidentEvent;
import com.gs.robot.cloud.diagnosis.entity.RobotCharge;
import com.gs.robot.cloud.diagnosis.entity.RobotOutage;
import com.gs.robot.cloud.diagnosis.entity.RobotState1dot0;
import com.gs.robot.cloud.diagnosis.function.RobotChargeAbnormalFunction;
import com.gs.robot.cloud.diagnosis.function.RobotOutageAbnormalFunction;
import com.gs.robot.cloud.diagnosis.function.filter.RobotChargeFilter;
import com.gs.robot.cloud.diagnosis.function.filter.RobotOutageFilter;
import com.gs.robot.cloud.diagnosis.function.window.RobotChargeAbnormalWindow;
import com.gs.robot.cloud.diagnosis.function.window.RobotOutageAbnormalWindow;
import com.gs.robot.cloud.diagnosis.lookup.RegionInfoLookupFunction;
import com.gs.robot.cloud.diagnosis.lookup.RobotInfoLookupFunction;
import com.gs.robot.cloud.diagnosis.lookup.RuleEnabledLookupFunction;
import com.gs.robot.cloud.diagnosis.sink.KafkaSinkFactory;
import com.gs.robot.cloud.diagnosis.source.KafkaSourceFactory;
import com.gs.robot.cloud.diagnosis.util.Converter;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.shaded.guava30.com.google.common.base.Preconditions;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

import java.time.Duration;
import java.util.Properties;

public class DiagnosisStreamJob {

  public static void main(String[] args) throws Exception {
    ParameterTool params = ParameterTool.fromArgs(args);
    validate(params);
    Properties properties = PropertiesHelper.loadProperties(params);
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//    env.setParallelism(1);
    WatermarkStrategy<RobotState1dot0> watermarkStrategy = WatermarkStrategy.<RobotState1dot0>forBoundedOutOfOrderness(Duration.ofMinutes(1))
        .withTimestampAssigner((event, timestamp)-> event.getRecvTimestampT().getTime());
    DataStream<RobotState1dot0> streamSource =
        env.fromSource(KafkaSourceFactory.getKafkaSource(properties), watermarkStrategy, "robot state 1.0");

    KafkaSink<IncidentEvent> sink = KafkaSinkFactory.getKafkaSink(properties);

    DataStream<RobotState1dot0> ruleEnabledDataStream;
    //是否匹配过滤掉不需要应用规则的机器
    if (properties.getProperty("ruleDim", "false").equals("true")) {
      ruleEnabledDataStream = streamSource.process(new RuleEnabledLookupFunction(properties))
          .filter(RobotState1dot0::getRuleEnabled);
    } else {
      ruleEnabledDataStream = streamSource;
    }

    //电池充电异常判断
    ruleEnabledDataStream.map((MapFunction<RobotState1dot0, RobotCharge>) Converter::robotState1dot02RobotCharge)
      .filter(new RobotChargeFilter())
      .keyBy(RobotCharge::getProductId)
      .window(TumblingEventTimeWindows.of(Time.minutes(30)))
      .apply(new RobotChargeAbnormalWindow())
      .process(new RobotChargeAbnormalFunction())
      .process(new RobotInfoLookupFunction(properties))
      .process(new RegionInfoLookupFunction(properties))
      .sinkTo(sink);

    //电池异常停车判断
    ruleEnabledDataStream.map((MapFunction<RobotState1dot0, RobotOutage>) Converter::robotState1dot02RobotStop)
        .filter(new RobotOutageFilter())
        .keyBy(RobotOutage::getProductId)
        .window(TumblingEventTimeWindows.of(Time.minutes(30)))
        .apply(new RobotOutageAbnormalWindow())
        .process(new RobotOutageAbnormalFunction())
        .process(new RobotInfoLookupFunction(properties))
        .process(new RegionInfoLookupFunction(properties))
        .sinkTo(sink);

    env.execute();
  }

  private static void validate(ParameterTool params) {
    Preconditions.checkNotNull(params.get("env"),
        String.format("Param %s can not null", "env"));

    if ("timestamp".equals(params.get("kafkaScanMode"))) {
      Preconditions.checkArgument(params.get("kafkaScanTimestamp") != null,
          String.format("kafkaScanMode is timestamp: Param %s can not null", "kafkaScanTimestamp"));
    }
  }
}
