package com.gs.robot.cloud.diagnosis.source;

import com.gs.robot.cloud.diagnosis.entity.RobotState1dot0;
import com.gs.robot.cloud.diagnosis.format.RobotState1dot0Deserialization;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.KafkaSourceBuilder;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.shaded.guava30.com.google.common.base.Preconditions;

import java.util.Properties;

public class KafkaSourceFactory {

  public static KafkaSource<RobotState1dot0> getKafkaSource(Properties properties) {
    KafkaSourceBuilder<RobotState1dot0> kafkaSourceBuilder = KafkaSource.<RobotState1dot0>builder()
        .setBootstrapServers(properties.getProperty("kafka.source.bootstrap.servers"))
        .setTopics(properties.getProperty("kafka.source.topic"))
        .setGroupId(properties.getProperty("kafka.source.group.id"))
        .setValueOnlyDeserializer(new RobotState1dot0Deserialization());
    KafkaSourceBuilder<RobotState1dot0> kafkaSourceBuilderScan = scanMode(kafkaSourceBuilder, properties);
    return kafkaSourceBuilderScan.build();
  }

  private static KafkaSourceBuilder<RobotState1dot0> scanMode(KafkaSourceBuilder<RobotState1dot0> kafkaSourceBuilder,
                                                              Properties properties) {
    String scanMode = properties.getProperty("kafkaScanMode", "group-offsets");
    switch (scanMode) {
      case "earliest":
        kafkaSourceBuilder.setStartingOffsets(OffsetsInitializer.earliest());
        break;
      case "latest":
        kafkaSourceBuilder.setStartingOffsets(OffsetsInitializer.latest());
        break;
      case "group-offsets":
        kafkaSourceBuilder.setStartingOffsets(OffsetsInitializer.committedOffsets());
        break;
      case "timestamp":
        Long timestamp = Preconditions.checkNotNull(Long.parseLong(properties.getProperty("kafkaScanTimestamp")));
        kafkaSourceBuilder.setStartingOffsets(OffsetsInitializer.timestamp(timestamp));
        break;
      default:
        throw new RuntimeException(String.format("no supported scan mode, %s", scanMode));
    }
    return kafkaSourceBuilder;
  }
}
