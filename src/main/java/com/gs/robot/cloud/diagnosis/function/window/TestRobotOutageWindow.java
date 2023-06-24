package com.gs.robot.cloud.diagnosis.function.window;

import com.gs.robot.cloud.diagnosis.entity.RobotOutage;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.util.Iterator;

public class TestRobotOutageWindow implements WindowFunction<RobotOutage, RobotOutage, String, TimeWindow> {

  @Override
  public void apply(String s, TimeWindow window, Iterable<RobotOutage> input, Collector<RobotOutage> out) throws Exception {
    Iterator<RobotOutage> iterator = input.iterator();
    while (iterator.hasNext()) {
      RobotOutage robotOutage = iterator.next();
      out.collect(robotOutage);
    }
  }
}
