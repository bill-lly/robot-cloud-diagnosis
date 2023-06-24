package com.gs.robot.cloud.diagnosis;

import com.gs.robot.cloud.diagnosis.entity.RobotCharge;
import com.gs.robot.cloud.diagnosis.function.RobotChargeAbnormalFunction;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RobotChargeAbnormalFunctionTest {

  private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Test
  //两个批次都满足条件
  public void testProcess1() throws Exception {
    RobotChargeAbnormalFunction function = new RobotChargeAbnormalFunction();
    CollectorPrint out = new CollectorPrint();
    List<List<RobotCharge>> testCases = new ArrayList<>();
    List<RobotCharge> robotCharges1 = new ArrayList<>();
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:00:00", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:00:30", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:01:00", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:01:30", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:02:00", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:02:30", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:03:00", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:03:30", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:04:00", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:04:30", 80.0));
    testCases.add(robotCharges1);

    List<RobotCharge> robotCharges2 = new ArrayList<>();
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:05:00", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:05:30", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:06:00", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:06:30", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:07:00", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:07:30", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:08:00", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:08:30", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:09:00", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:09:30", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:10:00", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:10:30", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:11:00", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:11:30", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:12:00", 80.0));
    testCases.add(robotCharges2);

    function.processElement(testCases, null, out);
  }

  @Test
  //两个批次，第一个不满足条件；第二个满足条件
  public void testProcess2() throws Exception {
    RobotChargeAbnormalFunction function = new RobotChargeAbnormalFunction();
    CollectorPrint out = new CollectorPrint();
    List<List<RobotCharge>> testCases = new ArrayList<>();
    List<RobotCharge> robotCharges1 = new ArrayList<>();
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:00:00", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:00:30", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:01:00", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:01:30", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:02:00", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:02:30", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:03:00", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:03:30", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:04:00", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:04:30", 100.0));
    testCases.add(robotCharges1);

    List<RobotCharge> robotCharges2 = new ArrayList<>();
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:05:00", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:05:30", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:06:00", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:06:30", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:07:00", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:07:30", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:08:00", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:08:30", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:09:00", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:09:30", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:10:00", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:10:30", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:11:00", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:11:30", 80.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:12:00", 80.0));
    testCases.add(robotCharges2);

    function.processElement(testCases, null, out);
  }

  @Test
  //两个批次都不满足条件
  public void testProcess3() throws Exception {
    RobotChargeAbnormalFunction function = new RobotChargeAbnormalFunction();
    CollectorPrint out = new CollectorPrint();
    List<List<RobotCharge>> testCases = new ArrayList<>();
    List<RobotCharge> robotCharges1 = new ArrayList<>();
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:00:00", 80.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:00:30", 79.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:01:00", 78.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:01:30", 77.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:02:00", 76.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:02:30", 75.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:03:00", 74.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:03:30", 73.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:04:00", 72.0));
    robotCharges1.add(createRobotCharge(true, "2023-04-20 10:04:30", 73.0));
    testCases.add(robotCharges1);

    List<RobotCharge> robotCharges2 = new ArrayList<>();
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:05:00", 100.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:05:30", 99.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:06:00", 98.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:06:30", 97.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:07:00", 96.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:07:30", 95.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:08:00", 94.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:08:30", 93.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:09:00", 92.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:09:30", 91.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:10:00", 90.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:10:30", 89.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:11:00", 88.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:11:30", 87.0));
    robotCharges2.add(createRobotCharge(true, "2023-04-20 10:12:00", 86.0));
    testCases.add(robotCharges2);

    function.processElement(testCases, null, out);
  }

  private RobotCharge createRobotCharge(boolean status, String time, Double battery) throws ParseException {
    RobotCharge robotCharge =  new RobotCharge();
    robotCharge.setChargerStatus(status);
    robotCharge.setCreatedAtT(simpleDateFormat.parse(time));
    robotCharge.setBattery(battery);
    return robotCharge;
  }

}
