package com.gs.robot.cloud.diagnosis.format;

import com.gs.robot.cloud.diagnosis.entity.IncidentEvent;
import org.apache.flink.api.common.serialization.SerializationSchema;

import java.nio.charset.StandardCharsets;

public class IncidentEventKeySerialization implements SerializationSchema<IncidentEvent> {

  @Override
  public byte[] serialize(IncidentEvent incidentEvent) {
    return incidentEvent.getSubjectId().getBytes(StandardCharsets.UTF_8);
  }
}
