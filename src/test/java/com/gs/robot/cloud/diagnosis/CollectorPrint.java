package com.gs.robot.cloud.diagnosis;

import org.apache.flink.util.Collector;

public class CollectorPrint implements Collector {

  @Override
  public void collect(Object record) {
    System.out.println(record);
  }

  @Override
  public void close() {
  }
}
