package com.gs.robot.cloud.diagnosis.lookup;

import com.gs.robot.cloud.diagnosis.entity.EntityBase;
import com.gs.robot.cloud.diagnosis.entity.IncidentEvent;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.connector.jdbc.JdbcConnectionOptions;
import org.apache.flink.connector.jdbc.internal.connection.JdbcConnectionProvider;
import org.apache.flink.connector.jdbc.internal.connection.SimpleJdbcConnectionProvider;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class RegionInfoLookupFunction extends ProcessFunction<IncidentEvent, IncidentEvent> {

  private final static String sql = "select product_id, maintenance_region_code from robot_maintenance_info where product_id = ?";
  private LookupProcessor lookupProcessor;

  public RegionInfoLookupFunction(Properties properties) {
    String jdbcUrl = properties.getProperty("gs.robot.jdbc.url");
    String userName = properties.getProperty("gs.robot.user.name");
    String password = properties.getProperty("gs.robot.password");
    JdbcConnectionOptions.JdbcConnectionOptionsBuilder builder = new JdbcConnectionOptions.JdbcConnectionOptionsBuilder();
    JdbcConnectionOptions options = builder.withUrl(jdbcUrl)
        .withUsername(userName)
        .withPassword(password)
        .withConnectionCheckTimeoutSeconds(60)
        .build();
    JdbcConnectionProvider connectionProvider = new SimpleJdbcConnectionProvider(options);
    lookupProcessor = new LookupProcessor(connectionProvider, sql, false);
  }

  @Override
  public void open(Configuration parameters) throws Exception {
    super.open(parameters);
    lookupProcessor.initCache();
    lookupProcessor.establishConnectionAndStatement();
  }

  @Override
  public void processElement(IncidentEvent value, Context ctx, Collector<IncidentEvent> out) throws Exception {
    List<EntityBase> entities = lookupProcessor.getEntities(value.getKey(), resultSet -> {
      try {
        IncidentEvent incidentEvent = new IncidentEvent();
        incidentEvent.setMaintenanceRegionCode(resultSet.getString(2));
        return incidentEvent;
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    });

    if (entities.isEmpty()) {
      out.collect(value);
    } else {
      for (EntityBase entity:entities) {
        IncidentEvent incidentEntity = (IncidentEvent)entity;
        value.setMaintenanceRegionCode(incidentEntity.getMaintenanceRegionCode());
        out.collect(value);
      }
    }
  }
}
