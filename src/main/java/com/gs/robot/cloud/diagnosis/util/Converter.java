package com.gs.robot.cloud.diagnosis.util;

import com.gs.robot.cloud.diagnosis.entity.IncidentEvent;
import com.gs.robot.cloud.diagnosis.entity.RobotCharge;
import com.gs.robot.cloud.diagnosis.entity.RobotState1dot0;
import com.gs.robot.cloud.diagnosis.entity.RobotOutage;

import java.util.UUID;

public class Converter {

  public static RobotCharge robotState1dot02RobotCharge(RobotState1dot0 robotState1dot0) {
    RobotCharge robotCharge = new RobotCharge();
    robotCharge.setProductId(robotState1dot0.getProductId());
    robotCharge.setChargerStatus(robotState1dot0.getChargerStatus());
    robotCharge.setBattery(robotState1dot0.getBattery());
    robotCharge.setCreatedAtT(robotState1dot0.getCreatedAtT());
    robotCharge.setRecvTimestampT(robotState1dot0.getRecvTimestampT());
    robotCharge.setModelType(robotState1dot0.getModelType());
    return robotCharge;
  }

  public static RobotOutage robotState1dot02RobotStop(RobotState1dot0 robotState1dot0) {
    RobotOutage robotOutage = new RobotOutage();
    robotOutage.setProductId(robotState1dot0.getProductId());
    robotOutage.setMileageLeft(robotState1dot0.getMileageLeft());
    robotOutage.setMileageRight(robotState1dot0.getMileageRight());
    robotOutage.setBattery(robotState1dot0.getBattery());
    robotOutage.setCreatedAtT(robotState1dot0.getCreatedAtT());
    robotOutage.setRecvTimestampT(robotState1dot0.getRecvTimestampT());
    robotOutage.setModelType(robotState1dot0.getModelType());
    return robotOutage;
  }

  public static IncidentEvent robotCharge2IncidentEvent(RobotCharge robotCharge) {
    IncidentEvent incidentEvent = new IncidentEvent();
    incidentEvent.setEventId(UUID.randomUUID().toString());
    incidentEvent.setSubjectId(robotCharge.getProductId());
    incidentEvent.setIncidentCode("800002");
    incidentEvent.setEventTime("2023-04-20 10:00:00");
    incidentEvent.setIncidentStartTime("2023-04-20 10:00:00");
    incidentEvent.setSoftwareVersion("version1");
    incidentEvent.setStatus("11");
    incidentEvent.setAlias("robot_name");
    incidentEvent.setSubjectType("BOT");
    incidentEvent.setFinalized(false);
    incidentEvent.setCleanType("CLEAN_TYPE_UNSPECIFIED");
    incidentEvent.setCustomerCode("222222");
    incidentEvent.setSubjectModel("hhhh");
    return incidentEvent;
  }

  public static IncidentEvent robotOutage2IncidentEvent(RobotOutage robotOutage) {
    IncidentEvent incidentEvent = new IncidentEvent();
    incidentEvent.setEventId(UUID.randomUUID().toString());
    incidentEvent.setSubjectId(robotOutage.getProductId());
    incidentEvent.setIncidentCode("800002");
    incidentEvent.setEventTime("2023-04-20 10:00:00");
    incidentEvent.setIncidentStartTime("2023-04-20 10:00:00");
    incidentEvent.setSoftwareVersion("version1");
    incidentEvent.setStatus("11");
    incidentEvent.setAlias("robot_name");
    incidentEvent.setSubjectType("BOT");
    incidentEvent.setFinalized(false);
    incidentEvent.setCleanType("CLEAN_TYPE_UNSPECIFIED");
    incidentEvent.setCustomerCode("222222");
    incidentEvent.setSubjectModel("hhhh");
    return incidentEvent;
  }
}
