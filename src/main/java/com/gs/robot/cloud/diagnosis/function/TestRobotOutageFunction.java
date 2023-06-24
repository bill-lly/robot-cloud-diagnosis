package com.gs.robot.cloud.diagnosis.function;

import com.gs.robot.cloud.diagnosis.entity.IncidentEvent;
import com.gs.robot.cloud.diagnosis.entity.RobotOutage;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;

import java.text.SimpleDateFormat;
import java.util.UUID;

public class TestRobotOutageFunction extends ProcessFunction<RobotOutage, IncidentEvent> {

  private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  @Override
  public void processElement(RobotOutage value, Context ctx, Collector<IncidentEvent> out) throws Exception {
    out.collect(createIncidentEvent(value));
  }

  private IncidentEvent createIncidentEvent(RobotOutage robotOutage) {
    IncidentEvent incidentEvent = new IncidentEvent();
    incidentEvent.setEventId(UUID.randomUUID().toString());
    //异常充电
    incidentEvent.setIncidentCode("800002");
    String eventTime = simpleDateFormat.format(robotOutage.getCreatedAtT());
    incidentEvent.setEventTime(eventTime);
    incidentEvent.setIncidentStartTime(eventTime);
    incidentEvent.setFinalized(false);
    incidentEvent.setCleanType("CLEAN_TYPE_UNSPECIFIED");
    incidentEvent.setSubjectId(robotOutage.getProductId());
    incidentEvent.setSubjectType("BOT");
    incidentEvent.setStatus("11");
    return incidentEvent;
  }
}
