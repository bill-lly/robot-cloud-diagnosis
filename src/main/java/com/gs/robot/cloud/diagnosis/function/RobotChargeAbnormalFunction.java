package com.gs.robot.cloud.diagnosis.function;

import com.gs.robot.cloud.diagnosis.entity.IncidentEvent;
import com.gs.robot.cloud.diagnosis.entity.RobotCharge;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

//电池充电异常
public class RobotChargeAbnormalFunction extends ProcessFunction<List<List<RobotCharge>>, IncidentEvent> {

  private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  @Override
  public void processElement(List<List<RobotCharge>> value,
                             Context ctx,
                             Collector<IncidentEvent> out) throws Exception {
    if (value == null || value.isEmpty()) {
      return;
    }

    for (List<RobotCharge> list : value) {
      boolean err = true;
      for (int i=1; i< list.size(); i++) {
        //每个批次只要有一条不满足下面条件，就认为没有问题
        //如果一阶差分数值 小于等于0并且电池battery != 100时，则发出电池无法充电告警
        if (list.get(i).getBattery() - list.get(i-1).getBattery() > 0
            || list.get(i).getBattery() >= 100 || list.get(i-1).getBattery() >=100 ) {
          err = false;
          break;
        }
      }
      //只要有一个批次数据由问题，就发生告警，一个窗口以内最多只发送一个告警
      if (err) {
        out.collect(createIncidentEvent(list.get(0)));
        return;
      }
    }
  }

  private IncidentEvent createIncidentEvent(RobotCharge robotCharge) {
    IncidentEvent incidentEvent = new IncidentEvent();
    incidentEvent.setEventId(UUID.randomUUID().toString());
    //异常充电
    incidentEvent.setIncidentCode("800002");
    String eventTime = simpleDateFormat.format(robotCharge.getCreatedAtT());
    incidentEvent.setEventTime(eventTime);
    incidentEvent.setIncidentStartTime(eventTime);
    incidentEvent.setFinalized(false);
    incidentEvent.setCleanType("CLEAN_TYPE_UNSPECIFIED");
    incidentEvent.setSubjectId(robotCharge.getProductId());
    incidentEvent.setSubjectType("BOT");
    incidentEvent.setStatus("11");
    incidentEvent.setSubjectModel(robotCharge.getModelType());
    return incidentEvent;
  }


}
