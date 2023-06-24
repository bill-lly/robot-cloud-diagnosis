package com.gs.robot.cloud.diagnosis.util;

import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.api.Schema;

public class SchemaUtil {

  public static Schema buildIncidentSchema() {
    Schema.Builder builder = Schema.newBuilder();
    builder.column("eventId", DataTypes.STRING());
    builder.column("subjectId", DataTypes.STRING());
    builder.column("subjectType", DataTypes.STRING());
    builder.column("subjectModel", DataTypes.STRING());
    builder.column("incidentCode", DataTypes.STRING());
    builder.column("incidentStartTime", DataTypes.STRING());
    builder.column("eventTime", DataTypes.STRING());
    builder.column("finalized", DataTypes.BOOLEAN());
    builder.column("cleanType", DataTypes.BOOLEAN());
    builder.column("status", DataTypes.BOOLEAN());
    return builder.build();
  }

}
