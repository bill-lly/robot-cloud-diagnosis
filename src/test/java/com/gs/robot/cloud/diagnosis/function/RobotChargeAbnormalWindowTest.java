package com.gs.robot.cloud.diagnosis.function;

import com.gs.robot.cloud.diagnosis.CollectorPrint;
import com.gs.robot.cloud.diagnosis.entity.RobotCharge;
import com.gs.robot.cloud.diagnosis.function.window.RobotChargeAbnormalWindow;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RobotChargeAbnormalWindowTest {

  private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Test
  //生成41全部为true的case
  //结果：封装成一个list 41条
  public void testProcess1() throws Exception {
    RobotChargeAbnormalWindow window = new RobotChargeAbnormalWindow();
    CollectorPrint out = new CollectorPrint();
    List<RobotCharge> robotCharges = new ArrayList<>();
    //生成41全部为true的case
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:00:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:00:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:01:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:01:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:02:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:02:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:03:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:03:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:04:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:04:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:05:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:05:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:06:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:06:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:07:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:07:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:08:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:08:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:09:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:09:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:10:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:10:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:11:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:11:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:12:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:12:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:13:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:13:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:14:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:14:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:15:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:15:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:16:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:16:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:17:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:17:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:18:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:18:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:19:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:19:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:20:00"));
    window.apply(null, null, robotCharges, out);
  }

  @Test
  //3个联系的批次，第一个10条，第二个9条，第三个15
  //结果：封装成2个list 10条，15条
  public void testProcess2() throws Exception {
    RobotChargeAbnormalWindow window = new RobotChargeAbnormalWindow();
    CollectorPrint out = new CollectorPrint();
    List<RobotCharge> robotCharges = new ArrayList<>();
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:00:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:00:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:01:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:01:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:02:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:02:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:03:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:03:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:04:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:04:30"));
    robotCharges.add(createRobotCharge(false, "2023-04-20 10:05:00")); //11
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:05:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:06:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:06:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:07:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:07:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:08:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:08:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:09:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:09:30"));
    robotCharges.add(createRobotCharge(false, "2023-04-20 10:10:00")); //21
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:10:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:11:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:11:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:12:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:12:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:13:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:13:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:14:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:14:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:15:00")); //31
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:15:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:16:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:16:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:17:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:17:30"));
    robotCharges.add(createRobotCharge(false, "2023-04-20 10:18:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:18:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:19:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:19:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:20:00")); //41
    window.apply(null, null, robotCharges, out);
  }

  @Test
  //多个false打散list,没有10个以上的联系case
  //结果：无
  public void testProcess3() throws Exception {
    RobotChargeAbnormalWindow window = new RobotChargeAbnormalWindow();
    CollectorPrint out = new CollectorPrint();
    List<RobotCharge> robotCharges = new ArrayList<>();
    robotCharges.add(createRobotCharge(false, "2023-04-20 10:00:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:00:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:01:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:01:30"));
    robotCharges.add(createRobotCharge(false, "2023-04-20 10:02:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:02:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:03:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:03:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:04:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:04:30"));
    robotCharges.add(createRobotCharge(false, "2023-04-20 10:05:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:05:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:06:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:06:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:07:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:07:30"));
    robotCharges.add(createRobotCharge(false, "2023-04-20 10:08:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:08:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:09:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:09:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:10:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:10:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:11:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:11:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:12:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:12:30"));
    robotCharges.add(createRobotCharge(false, "2023-04-20 10:13:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:13:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:14:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:14:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:15:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:15:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:16:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:16:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:17:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:17:30"));
    robotCharges.add(createRobotCharge(false, "2023-04-20 10:18:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:18:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:19:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:19:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:20:00"));
    window.apply(null, null, robotCharges, out);
  }

  @Test
  //测试去重功能
  //结果：无
  public void testProcess4() throws Exception {
    RobotChargeAbnormalWindow window = new RobotChargeAbnormalWindow();
    CollectorPrint out = new CollectorPrint();
    List<RobotCharge> robotCharges = new ArrayList<>();
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:00:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:00:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:01:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:01:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:01:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:01:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:02:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:02:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:03:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:03:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:04:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:04:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:05:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:05:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:06:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:06:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:07:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:07:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:07:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:07:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:08:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:08:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:09:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:09:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:10:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:10:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:11:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:11:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:12:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:12:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:13:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:13:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:14:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:14:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:15:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:15:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:16:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:16:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:17:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:17:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:18:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:18:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:19:00"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:19:30"));
    robotCharges.add(createRobotCharge(true, "2023-04-20 10:20:00"));
    window.apply(null, null, robotCharges, out);
  }



  private RobotCharge createRobotCharge(boolean status, String time) throws ParseException {
    RobotCharge robotCharge =  new RobotCharge();
    robotCharge.setChargerStatus(status);
    robotCharge.setCreatedAtT(simpleDateFormat.parse(time));
    return robotCharge;
  }


}
