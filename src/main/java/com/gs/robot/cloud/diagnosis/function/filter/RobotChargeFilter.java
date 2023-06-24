package com.gs.robot.cloud.diagnosis.function.filter;

import com.gs.robot.cloud.diagnosis.entity.RobotCharge;
import org.apache.flink.api.common.functions.FilterFunction;

public class RobotChargeFilter implements FilterFunction<RobotCharge> {

  @Override
  public boolean filter(RobotCharge value) throws Exception {
    if (value.getCreatedAtT() == null
        || value.getChargerStatus() == null
        || value.getBattery() == null
        || value.getRecvTimestampT() == null) {
      return false;
    }
    return true;
  }
}
