package com.gs.robot.cloud.diagnosis.lookup;

import com.gs.robot.cloud.diagnosis.entity.EntityBase;
import com.gs.robot.cloud.diagnosis.entity.RobotState1dot0;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.connector.jdbc.JdbcConnectionOptions;
import org.apache.flink.connector.jdbc.internal.connection.JdbcConnectionProvider;
import org.apache.flink.connector.jdbc.internal.connection.SimpleJdbcConnectionProvider;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class RuleEnabledLookupFunction extends ProcessFunction<RobotState1dot0, RobotState1dot0>{

  private static final Logger LOG = LoggerFactory.getLogger(LookupProcessor.class);
  private final static String sql = "select product_id, rule_enabled from bg_rt_cloud_robot_dim where product_id = ?";
  private LookupProcessor lookupProcessor;

  public RuleEnabledLookupFunction(Properties properties) {
    String jdbcUrl = properties.getProperty("bigdataRealDim.jdbc.url");
    String userName = properties.getProperty("bigdataRealDim.user.name");
    String password = properties.getProperty("bigdataRealDim.password");
    JdbcConnectionOptions.JdbcConnectionOptionsBuilder builder = new JdbcConnectionOptions.JdbcConnectionOptionsBuilder();
    JdbcConnectionOptions options = builder.withUrl(jdbcUrl)
        .withUsername(userName)
        .withPassword(password)
        .withConnectionCheckTimeoutSeconds(60)
        .build();
    JdbcConnectionProvider connectionProvider = new SimpleJdbcConnectionProvider(options);
    lookupProcessor = new LookupProcessor(connectionProvider, sql, true);
  }

  @Override
  public void open(Configuration parameters) throws Exception {
    super.open(parameters);
    lookupProcessor.initCache();
    lookupProcessor.establishConnectionAndStatement();
  }

  @Override
  public void processElement(RobotState1dot0 value, Context ctx, Collector<RobotState1dot0> out) throws Exception {
    List<EntityBase> entities = lookupProcessor.getEntities(value.getKey(), resultSet -> {
      try {
        RobotState1dot0 robotState1dot0 = new RobotState1dot0();
        robotState1dot0.setRuleEnabled(resultSet.getBoolean(2));
        return robotState1dot0;
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    });

    if (entities.isEmpty()) {
      out.collect(value);
    } else {
      for (EntityBase entity:entities) {
        RobotState1dot0 robotState1dot0Entity = (RobotState1dot0)entity;
        value.setRuleEnabled(robotState1dot0Entity.getRuleEnabled());
        out.collect(value);
      }
    }
  }
}
