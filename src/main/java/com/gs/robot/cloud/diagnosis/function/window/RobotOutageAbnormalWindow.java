package com.gs.robot.cloud.diagnosis.function.window;

import com.gs.robot.cloud.diagnosis.entity.RobotOutage;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RobotOutageAbnormalWindow implements WindowFunction<RobotOutage, List<List<RobotOutage>>, String, TimeWindow> {

  @Override
  public void apply(String s,
                    TimeWindow window,
                    Iterable<RobotOutage> input,
                    Collector<List<List<RobotOutage>>> out) throws Exception {
    List<RobotOutage> list = (List<RobotOutage>)input;
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

    //筛选出里程数极小值和前后两个记录
    List<List<RobotOutage>> output = new ArrayList<>();
    //过滤掉第一条和最后一条数据
    for (int i=1; i< list.size()-1; i++) {
      List<RobotOutage> batch = new ArrayList<>();
      Double mileagePre = list.get(i-1).getMileageLeft() + list.get(i-1).getMileageRight();
      Double mileageCur = list.get(i).getMileageLeft() + list.get(i).getMileageRight();
      //找到里程数大于等于0小于5的点，作为机器停住的佐证，且不为起始或者最后一条数据
      if (mileageCur - mileagePre >= 0 && mileageCur - mileagePre < 5) {
        Double batteryPre = list.get(i-1).getBattery();
        Double batteryNext = list.get(i+1).getBattery();
        //并且前后数据的差分<-25, 对应电流<90
        if (batteryNext-batteryPre<-25 && batteryPre<90 && batteryNext<90) {
          batch.add(list.get(i-1));
          batch.add(list.get(i+1));
          output.add(batch);
        }
      }
    }
    if (!output.isEmpty()) {
      out.collect(output);
    }
  }

  private void deduplicate(List<RobotOutage> list) {
    long pre = list.get(0).getCreatedAtT().getTime();
    int i = 0;
    Iterator<RobotOutage> iterator = list.iterator();
    while (iterator.hasNext()) {
      RobotOutage robotOutage = iterator.next();
      if (++i == 1) {
        continue;
      }
      if (robotOutage.getCreatedAtT().getTime() == pre) {
        iterator.remove();
      }
      pre = robotOutage.getCreatedAtT().getTime();
    }
  }
}
