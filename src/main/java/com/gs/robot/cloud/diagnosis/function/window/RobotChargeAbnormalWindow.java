package com.gs.robot.cloud.diagnosis.function.window;

import com.gs.robot.cloud.diagnosis.entity.RobotCharge;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//电池充电异常
public class RobotChargeAbnormalWindow implements WindowFunction<RobotCharge, List<List<RobotCharge>>, String, TimeWindow> {

  @Override
  public void apply(String s,
                    TimeWindow window,
                    Iterable<RobotCharge> input,
                    Collector<List<List<RobotCharge>>> out) throws Exception {
    List<RobotCharge> list = (List<RobotCharge>)input;
    //小于40条数据，判断为数据量不够，不做判断
    if (list.size() <= 40) {
      return;
    }
    //对数据按create_at时间排序
    Collections.sort(list);

    //出现重复数据会导致规则误判，所以需要排序后去重
    deduplicate(list);

    //去重后的数据必须大于40
    if (list.size() <= 40) {
      return;
    }

    //这边只需要统计连续chargerStatus=1的case,并且case的数量大于10的数据
    //将每一个连续的批次封装成一个list；然后将多个批次再封装成一个list<list<>>
    List<List<RobotCharge>> output = new ArrayList<>();
    List<RobotCharge> batch = new ArrayList<>();
    if (list.get(0).getChargerStatus()) {
      batch.add(list.get(0));
    }
    for (int i=1; i< list.size(); i++) {
      if ((list.get(i).getChargerStatus() && batch.isEmpty())
          || (list.get(i-1).getChargerStatus() && list.get(i).getChargerStatus())) {
        batch.add(list.get(i));
      } else {
        batch = flushAndClearIfNeed(batch, output);
      }
    }
    flushAndClearIfNeed(batch, output);
    if (!output.isEmpty()) {
      out.collect(output);
    }
  }

  private List<RobotCharge> flushAndClearIfNeed(List<RobotCharge> batch, List<List<RobotCharge>> output) {
    if (batch.size() >= 10) {
      output.add(batch);
    }
    return new ArrayList<>();
  }

  private void deduplicate(List<RobotCharge> list) {
    long pre = list.get(0).getCreatedAtT().getTime();
    int i = 0;
    Iterator<RobotCharge> iterator = list.iterator();
    while (iterator.hasNext()) {
      RobotCharge robotCharge = iterator.next();
      if (++i == 1) {
        continue;
      }
      if (robotCharge.getCreatedAtT().getTime() == pre) {
        iterator.remove();
      }
      pre = robotCharge.getCreatedAtT().getTime();
    }
  }
}
