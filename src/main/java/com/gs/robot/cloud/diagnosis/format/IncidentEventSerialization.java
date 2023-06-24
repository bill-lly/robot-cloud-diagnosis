package com.gs.robot.cloud.diagnosis.format;

import com.gs.robot.cloud.diagnosis.entity.IncidentEvent;
import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.JsonNode;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;

import java.nio.charset.StandardCharsets;

public class IncidentEventSerialization implements SerializationSchema<IncidentEvent> {

  private static final ObjectMapper objectMapper = new ObjectMapper();
  private static final JsonNodeFactory JSON_NODE_FACTORY = JsonNodeFactory.withExactBigDecimals(true);

  @Override
  public byte[] serialize(IncidentEvent incidentEvent) {
      JsonNode jsonNode = objectMapper.convertValue(incidentEvent, JsonNode.class);
      ObjectNode metas = JSON_NODE_FACTORY.objectNode();
      metas.set("alias", JSON_NODE_FACTORY.textNode(incidentEvent.getAlias()));
      metas.set("status", JSON_NODE_FACTORY.textNode(incidentEvent.getStatus()));
      metas.set("softwareVersion", JSON_NODE_FACTORY.textNode(incidentEvent.getSoftwareVersion()));
      metas.set("contractedCustomer", JSON_NODE_FACTORY.textNode(incidentEvent.getCustomerCode()));
      metas.set("maintainedRegion", JSON_NODE_FACTORY.textNode(incidentEvent.getMaintenanceRegionCode()));
      ((ObjectNode)jsonNode).set("metas", metas);
      return jsonNode.toString().getBytes(StandardCharsets.UTF_8);
  }
}
