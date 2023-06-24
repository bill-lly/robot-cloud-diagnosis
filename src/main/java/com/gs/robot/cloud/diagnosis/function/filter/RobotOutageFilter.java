package com.gs.robot.cloud.diagnosis.function.filter;

import com.gs.robot.cloud.diagnosis.entity.RobotOutage;
import org.apache.flink.api.common.functions.FilterFunction;

public class RobotOutageFilter implements FilterFunction<RobotOutage> {
  @Override
  public boolean filter(RobotOutage value) throws Exception {
    if (value.getCreatedAtT() == null
        || value.getRecvTimestampT() == null
        || value.getBattery() == null
        || value.getMileageRight() == null
        || value.getMileageLeft() == null) {
      return false;
    }
    return true;
  }
}
