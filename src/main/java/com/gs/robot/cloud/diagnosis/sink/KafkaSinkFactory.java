package com.gs.robot.cloud.diagnosis.sink;

import com.gs.robot.cloud.diagnosis.entity.IncidentEvent;
import com.gs.robot.cloud.diagnosis.format.IncidentEventKeySerialization;
import com.gs.robot.cloud.diagnosis.format.IncidentEventSerialization;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaSink;

import java.util.Properties;

public class KafkaSinkFactory {

  public static KafkaSink<IncidentEvent> getKafkaSink(Properties properties) {
    KafkaSink<IncidentEvent> sink = KafkaSink.<IncidentEvent>builder()
        .setBootstrapServers(properties.getProperty("kafka.sink.bootstrap.servers"))
        .setRecordSerializer(KafkaRecordSerializationSchema.builder()
            .setTopic(properties.getProperty("kafka.sink.topic"))
            .setKeySerializationSchema(new IncidentEventKeySerialization())
            .setValueSerializationSchema(new IncidentEventSerialization())
            .build())
        .build();
    return sink;
  }

}

