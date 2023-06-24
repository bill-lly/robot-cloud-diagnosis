package com.gs.robot.cloud.diagnosis.function;

import com.gs.robot.cloud.diagnosis.CollectorPrint;
import com.gs.robot.cloud.diagnosis.entity.RobotOutage;
import com.gs.robot.cloud.diagnosis.function.window.RobotOutageAbnormalWindow;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RobotOutageAbnormalWindowTest {

  private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Test
  //没有满足条件的case
  public void testProcess01() throws Exception {
    RobotOutageAbnormalWindow window = new RobotOutageAbnormalWindow();
    CollectorPrint out = new CollectorPrint();
    List<RobotOutage> robotOutages = new ArrayList<>();
    robotOutages.add(createRobotOutage("2023-04-20 10:00:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:00:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:01:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:01:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:02:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:02:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:03:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:03:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:04:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:04:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:05:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:05:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:06:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:06:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:07:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:07:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:08:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:08:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:09:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:09:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:10:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:10:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:11:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:11:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:12:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:12:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:13:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:13:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:14:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:14:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:15:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:15:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:16:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:16:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:17:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:17:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:18:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:18:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:19:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:19:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:20:00", 10.0, 10.0, 80.0));
    window.apply(null, null, robotOutages, out);
  }

  @Test
  //没有满足条件的case
  public void testProcess02() throws Exception {
    RobotOutageAbnormalWindow window = new RobotOutageAbnormalWindow();
    CollectorPrint out = new CollectorPrint();
    List<RobotOutage> robotOutages = new ArrayList<>();
    robotOutages.add(createRobotOutage("2023-04-20 10:00:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:00:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:01:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:01:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:02:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:02:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:03:00", 12.0, 13.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:03:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:04:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:04:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:05:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:05:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:06:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:06:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:07:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:07:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:08:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:08:30", 12.0, 12.0, 54.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:09:00", 10.0, 10.0, 54.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:09:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:10:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:10:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:11:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:11:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:12:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:12:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:13:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:13:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:14:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:14:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:15:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:15:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:16:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:16:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:17:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:17:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:18:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:18:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:19:00", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:19:30", 10.0, 10.0, 80.0));
    robotOutages.add(createRobotOutage("2023-04-20 10:20:00", 10.0, 10.0, 80.0));
    window.apply(null, null, robotOutages, out);
  }

  public RobotOutage createRobotOutage(String time, Double left, Double right, Double battery) throws ParseException {
    RobotOutage robotOutage = new RobotOutage();
    robotOutage.setCreatedAtT(simpleDateFormat.parse(time));
    robotOutage.setMileageLeft(left);
    robotOutage.setMileageRight(right);
    robotOutage.setBattery(battery);
    return robotOutage;
  }



}
