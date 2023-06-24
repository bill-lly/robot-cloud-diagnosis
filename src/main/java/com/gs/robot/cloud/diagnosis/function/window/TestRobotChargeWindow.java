package com.gs.robot.cloud.diagnosis.function.window;

import com.gs.robot.cloud.diagnosis.entity.RobotCharge;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.util.Iterator;

public class TestRobotChargeWindow implements WindowFunction<RobotCharge, RobotCharge, String, TimeWindow> {

  @Override
  public void apply(String s, TimeWindow window, Iterable<RobotCharge> input, Collector<RobotCharge> out) throws Exception {
    Iterator<RobotCharge> iterator = input.iterator();
    while (iterator.hasNext()) {
      RobotCharge robotCharge = iterator.next();
      out.collect(robotCharge);
    }
  }
}
