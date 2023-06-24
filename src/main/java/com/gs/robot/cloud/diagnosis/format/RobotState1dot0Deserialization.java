package com.gs.robot.cloud.diagnosis.format;

import com.gs.robot.cloud.diagnosis.entity.RobotState1dot0;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RobotState1dot0Deserialization implements DeserializationSchema<RobotState1dot0> {

  private static final long serialVersionUID = 1L;

  private static final ObjectMapper objectMapper = new ObjectMapper();

  /**
   * The charset to use to convert between strings and bytes. The field is transient because we
   * serialize a different delegate object instead
   */

  @Override
  public RobotState1dot0 deserialize(byte[] message) throws IOException {
    String s = new String(message, StandardCharsets.UTF_8);
    return objectMapper.readValue(s, RobotState1dot0.class);
  }

  @Override
  public boolean isEndOfStream(RobotState1dot0 nextElement) {
    return false;
  }

  @Override
  public TypeInformation<RobotState1dot0> getProducedType() {
    return TypeInformation.of(RobotState1dot0.class);
  }
}
