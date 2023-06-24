package com.gs.robot.cloud.diagnosis.entity;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RobotState1dot0 extends EntityBase {

  //分区日期
  @JsonProperty("pt")
  private String pt;
  //机器人sn
  @JsonProperty("product_id")
  private String productId;
  //数据接受时间
  @JsonProperty("recv_timestamp")
  private Long recvTimestamp;
  //创建时间
  @JsonProperty("created_at")
  private Long createdAt;
  //数据接受时间
  @JsonProperty("recv_timestamp_t")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date recvTimestampT;
  //创建时间
  @JsonProperty("created_at_t")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date createdAtT;
  //4G信号强度
  @JsonProperty("fourg_signal_strength")
  private Integer fourGSignalStrength;
  //是否需要确认电梯位置
  @JsonProperty("location_need_confirm_elevator")
  private Boolean locationNeedConfirmElevator;
  //state-of-charge
  @JsonProperty("soc")
  private Integer soc;
  //电池
  @JsonProperty("battery")
  private Double battery;
  //电池单元数
  @JsonProperty("battery_cell_number")
  private Integer batteryCellNumber;
  //电池电流
  @JsonProperty("battery_current")
  private Double batteryCurrent;
  //电池半电压
  @JsonProperty("battery_half_voltage")
  private Integer batteryHalfVoltage;
  //电池电压
  @JsonProperty("battery_voltage")
  private Double batteryVoltage;
  //是否充电
  @JsonProperty("charge")
  private Boolean charge;
  //充电电流
  @JsonProperty("charge_current")
  private Integer chargeCurrent;
  //充电次数
  @JsonProperty("charge_num")
  private Integer chargeNum;
  //充电器
  @JsonProperty("charger")
  private Integer charger;
  //充电器电流
  @JsonProperty("charger_current")
  private Double chargerCurrent;
  //充电桩状态
  @JsonProperty("charger_pile_status")
  private Integer chargerPileStatus;
  //充电器状态
  @JsonProperty("charger_status")
  private Boolean chargerStatus;
  //充电器电压
  @JsonProperty("charger_voltage")
  private Double chargerVoltage;
  //详细充电器电流ADC
  @JsonProperty("detailed_charger_current_adc")
  private Integer detailedChargerCurrentAdc;
  //详细充电器电压ADC
  @JsonProperty("detailed_charger_voltage_adc")
  private Integer detailedChargerVoltageAdc;
  //详细计数左侧
  @JsonProperty("detailed_counts_left")
  private Integer detailedCountsLeft;
  //详细计数右侧
  @JsonProperty("detailed_counts_right")
  private Integer detailedCountsRight;
  //手动充电器连接
  @JsonProperty("manual_charger_connection")
  private Boolean manualChargerConnection;
  //手动充电
  @JsonProperty("manual_charging")
  private Boolean manualCharging;
  //里程数
  @JsonProperty("mileage")
  private Double mileage;
  //左侧里程数
  @JsonProperty("mileage_left")
  private Double mileageLeft;
  //右侧里程数
  @JsonProperty("mileage_right")
  private Double mileageRight;
  //左侧马达电流
  @JsonProperty("left_motor_current")
  private Integer leftMotorCurrent;
  //右侧马达电流
  @JsonProperty("right_motor_current")
  private Integer rightMotorCurrent;
  //左侧马达温度
  @JsonProperty("left_motor_temperature")
  private Integer leftMotorTemperature;
  //右侧马达温度
  @JsonProperty("right_motor_temperature")
  private Integer rightMotorTemperature;
  //左侧刷子使用情况
  @JsonProperty("left_side_brush_usage")
  private Double leftSideBrushUsage;
  //右侧刷子使用情况
  @JsonProperty("right_side_brush_usage")
  private Double rightSideBrushUsage;
  //滚刷使用情况
  @JsonProperty("roller_squeegee_usage")
  private Double rollerSqueegeeUsage;
  //滚刷使用情况警报
  @JsonProperty("roller_squeegee_usage_alert")
  private Double rollerSqueegeeUsageAlert;
  //滚刷马达
  @JsonProperty("rolling_brush_motor")
  private Boolean rollingBrushMotor;
  //滚刷压力级别
  @JsonProperty("rolling_brush_pressure_level")
  private Integer rollingBrushPressureLevel;
  //滚刷压力值
  @JsonProperty("rolling_brush_pressure_value")
  private Integer rollingBrushPressureValue;
  //滚刷使用情况
  @JsonProperty("rolling_brush_usage")
  private Double rollingBrushUsage;
  //滚刷使用情况警报
  @JsonProperty("rolling_brush_usage_alert")
  private Double rollingBrushUsageAlert;
  //model type
  @JsonProperty("model_type")
  private String modelType;
  @JsonIgnore
  private boolean ruleEnabled;

  public String getPt() {
    return pt;
  }

  public void setPt(String pt) {
    this.pt = pt;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Long getRecvTimestamp() {
    return recvTimestamp;
  }

  public void setRecvTimestamp(Long recvTimestamp) {
    this.recvTimestamp = recvTimestamp;
  }

  public Long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  public Date getRecvTimestampT() {
    return recvTimestampT;
  }

  public void setRecvTimestampT(Date recvTimestampT) {
    this.recvTimestampT = recvTimestampT;
  }

  public Date getCreatedAtT() {
    return createdAtT;
  }

  public void setCreatedAtT(Date createdAtT) {
    this.createdAtT = createdAtT;
  }

  public Integer getFourGSignalStrength() {
    return fourGSignalStrength;
  }

  public void setFourGSignalStrength(Integer fourGSignalStrength) {
    this.fourGSignalStrength = fourGSignalStrength;
  }

  public Boolean getLocationNeedConfirmElevator() {
    return locationNeedConfirmElevator;
  }

  public void setLocationNeedConfirmElevator(Boolean locationNeedConfirmElevator) {
    this.locationNeedConfirmElevator = locationNeedConfirmElevator;
  }

  public Integer getSoc() {
    return soc;
  }

  public void setSoc(Integer soc) {
    this.soc = soc;
  }

  public Double getBattery() {
    return battery;
  }

  public void setBattery(Double battery) {
    this.battery = battery;
  }

  public Integer getBatteryCellNumber() {
    return batteryCellNumber;
  }

  public void setBatteryCellNumber(Integer batteryCellNumber) {
    this.batteryCellNumber = batteryCellNumber;
  }

  public Double getBatteryCurrent() {
    return batteryCurrent;
  }

  public void setBatteryCurrent(Double batteryCurrent) {
    this.batteryCurrent = batteryCurrent;
  }

  public Integer getBatteryHalfVoltage() {
    return batteryHalfVoltage;
  }

  public void setBatteryHalfVoltage(Integer batteryHalfVoltage) {
    this.batteryHalfVoltage = batteryHalfVoltage;
  }

  public Double getBatteryVoltage() {
    return batteryVoltage;
  }

  public void setBatteryVoltage(Double batteryVoltage) {
    this.batteryVoltage = batteryVoltage;
  }

  public Boolean getCharge() {
    return charge;
  }

  public void setCharge(Boolean charge) {
    this.charge = charge;
  }

  public Integer getChargeCurrent() {
    return chargeCurrent;
  }

  public void setChargeCurrent(Integer chargeCurrent) {
    this.chargeCurrent = chargeCurrent;
  }

  public Integer getChargeNum() {
    return chargeNum;
  }

  public void setChargeNum(Integer chargeNum) {
    this.chargeNum = chargeNum;
  }

  public Integer getCharger() {
    return charger;
  }

  public void setCharger(Integer charger) {
    this.charger = charger;
  }

  public Double getChargerCurrent() {
    return chargerCurrent;
  }

  public void setChargerCurrent(Double chargerCurrent) {
    this.chargerCurrent = chargerCurrent;
  }

  public Integer getChargerPileStatus() {
    return chargerPileStatus;
  }

  public void setChargerPileStatus(Integer chargerPileStatus) {
    this.chargerPileStatus = chargerPileStatus;
  }

  public Boolean getChargerStatus() {
    return chargerStatus;
  }

  public void setChargerStatus(Boolean chargerStatus) {
    this.chargerStatus = chargerStatus;
  }

  public Double getChargerVoltage() {
    return chargerVoltage;
  }

  public void setChargerVoltage(Double chargerVoltage) {
    this.chargerVoltage = chargerVoltage;
  }

  public Integer getDetailedChargerCurrentAdc() {
    return detailedChargerCurrentAdc;
  }

  public void setDetailedChargerCurrentAdc(Integer detailedChargerCurrentAdc) {
    this.detailedChargerCurrentAdc = detailedChargerCurrentAdc;
  }

  public Integer getDetailedChargerVoltageAdc() {
    return detailedChargerVoltageAdc;
  }

  public void setDetailedChargerVoltageAdc(Integer detailedChargerVoltageAdc) {
    this.detailedChargerVoltageAdc = detailedChargerVoltageAdc;
  }

  public Integer getDetailedCountsLeft() {
    return detailedCountsLeft;
  }

  public void setDetailedCountsLeft(Integer detailedCountsLeft) {
    this.detailedCountsLeft = detailedCountsLeft;
  }

  public Integer getDetailedCountsRight() {
    return detailedCountsRight;
  }

  public void setDetailedCountsRight(Integer detailedCountsRight) {
    this.detailedCountsRight = detailedCountsRight;
  }

  public Boolean getManualChargerConnection() {
    return manualChargerConnection;
  }

  public void setManualChargerConnection(Boolean manualChargerConnection) {
    this.manualChargerConnection = manualChargerConnection;
  }

  public Boolean getManualCharging() {
    return manualCharging;
  }

  public void setManualCharging(Boolean manualCharging) {
    this.manualCharging = manualCharging;
  }

  public Double getMileage() {
    return mileage;
  }

  public void setMileage(Double mileage) {
    this.mileage = mileage;
  }

  public Double getMileageLeft() {
    return mileageLeft;
  }

  public void setMileageLeft(Double mileageLeft) {
    this.mileageLeft = mileageLeft;
  }

  public Double getMileageRight() {
    return mileageRight;
  }

  public void setMileageRight(Double mileageRight) {
    this.mileageRight = mileageRight;
  }

  public Integer getLeftMotorCurrent() {
    return leftMotorCurrent;
  }

  public void setLeftMotorCurrent(Integer leftMotorCurrent) {
    this.leftMotorCurrent = leftMotorCurrent;
  }

  public Integer getRightMotorCurrent() {
    return rightMotorCurrent;
  }

  public void setRightMotorCurrent(Integer rightMotorCurrent) {
    this.rightMotorCurrent = rightMotorCurrent;
  }

  public Integer getLeftMotorTemperature() {
    return leftMotorTemperature;
  }

  public void setLeftMotorTemperature(Integer leftMotorTemperature) {
    this.leftMotorTemperature = leftMotorTemperature;
  }

  public Integer getRightMotorTemperature() {
    return rightMotorTemperature;
  }

  public void setRightMotorTemperature(Integer rightMotorTemperature) {
    this.rightMotorTemperature = rightMotorTemperature;
  }

  public Double getLeftSideBrushUsage() {
    return leftSideBrushUsage;
  }

  public void setLeftSideBrushUsage(Double leftSideBrushUsage) {
    this.leftSideBrushUsage = leftSideBrushUsage;
  }

  public Double getRightSideBrushUsage() {
    return rightSideBrushUsage;
  }

  public void setRightSideBrushUsage(Double rightSideBrushUsage) {
    this.rightSideBrushUsage = rightSideBrushUsage;
  }

  public Double getRollerSqueegeeUsage() {
    return rollerSqueegeeUsage;
  }

  public void setRollerSqueegeeUsage(Double rollerSqueegeeUsage) {
    this.rollerSqueegeeUsage = rollerSqueegeeUsage;
  }

  public Double getRollerSqueegeeUsageAlert() {
    return rollerSqueegeeUsageAlert;
  }

  public void setRollerSqueegeeUsageAlert(Double rollerSqueegeeUsageAlert) {
    this.rollerSqueegeeUsageAlert = rollerSqueegeeUsageAlert;
  }

  public Boolean getRollingBrushMotor() {
    return rollingBrushMotor;
  }

  public void setRollingBrushMotor(Boolean rollingBrushMotor) {
    this.rollingBrushMotor = rollingBrushMotor;
  }

  public Integer getRollingBrushPressureLevel() {
    return rollingBrushPressureLevel;
  }

  public void setRollingBrushPressureLevel(Integer rollingBrushPressureLevel) {
    this.rollingBrushPressureLevel = rollingBrushPressureLevel;
  }

  public Integer getRollingBrushPressureValue() {
    return rollingBrushPressureValue;
  }

  public void setRollingBrushPressureValue(Integer rollingBrushPressureValue) {
    this.rollingBrushPressureValue = rollingBrushPressureValue;
  }

  public Double getRollingBrushUsage() {
    return rollingBrushUsage;
  }

  public void setRollingBrushUsage(Double rollingBrushUsage) {
    this.rollingBrushUsage = rollingBrushUsage;
  }

  public Double getRollingBrushUsageAlert() {
    return rollingBrushUsageAlert;
  }

  public void setRollingBrushUsageAlert(Double rollingBrushUsageAlert) {
    this.rollingBrushUsageAlert = rollingBrushUsageAlert;
  }

  public boolean getRuleEnabled() {
    return ruleEnabled;
  }

  public void setRuleEnabled(boolean ruleEnabled) {
    this.ruleEnabled = ruleEnabled;
  }

  public String getModelType() {
    return modelType;
  }

  public void setModelType(String modelType) {
    this.modelType = modelType;
  }

  @Override
  public String getKey() {
    return getProductId();
  }

  @Override
  public String toString() {
    return "RobotState1dot0{" +
        "pt='" + pt + '\'' +
        ", productId='" + productId + '\'' +
        ", recvTimestamp=" + recvTimestamp +
        ", createdAt=" + createdAt +
        ", recvTimestampT=" + recvTimestampT +
        ", createdAtT=" + createdAtT +
        ", fourGSignalStrength=" + fourGSignalStrength +
        ", locationNeedConfirmElevator=" + locationNeedConfirmElevator +
        ", soc=" + soc +
        ", battery=" + battery +
        ", batteryCellNumber=" + batteryCellNumber +
        ", batteryCurrent=" + batteryCurrent +
        ", batteryHalfVoltage=" + batteryHalfVoltage +
        ", batteryVoltage=" + batteryVoltage +
        ", charge=" + charge +
        ", chargeCurrent=" + chargeCurrent +
        ", chargeNum=" + chargeNum +
        ", charger=" + charger +
        ", chargerCurrent=" + chargerCurrent +
        ", chargerPileStatus=" + chargerPileStatus +
        ", chargerStatus=" + chargerStatus +
        ", chargerVoltage=" + chargerVoltage +
        ", detailedChargerCurrentAdc=" + detailedChargerCurrentAdc +
        ", detailedChargerVoltageAdc=" + detailedChargerVoltageAdc +
        ", detailedCountsLeft=" + detailedCountsLeft +
        ", detailedCountsRight=" + detailedCountsRight +
        ", manualChargerConnection=" + manualChargerConnection +
        ", manualCharging=" + manualCharging +
        ", mileage=" + mileage +
        ", mileageLeft=" + mileageLeft +
        ", mileageRight=" + mileageRight +
        ", leftMotorCurrent=" + leftMotorCurrent +
        ", rightMotorCurrent=" + rightMotorCurrent +
        ", leftMotorTemperature=" + leftMotorTemperature +
        ", rightMotorTemperature=" + rightMotorTemperature +
        ", leftSideBrushUsage=" + leftSideBrushUsage +
        ", rightSideBrushUsage=" + rightSideBrushUsage +
        ", rollerSqueegeeUsage=" + rollerSqueegeeUsage +
        ", rollerSqueegeeUsageAlert=" + rollerSqueegeeUsageAlert +
        ", rollingBrushMotor=" + rollingBrushMotor +
        ", rollingBrushPressureLevel=" + rollingBrushPressureLevel +
        ", rollingBrushPressureValue=" + rollingBrushPressureValue +
        ", rollingBrushUsage=" + rollingBrushUsage +
        ", rollingBrushUsageAlert=" + rollingBrushUsageAlert +
        ", modelType='" + modelType + '\'' +
        ", ruleEnabled=" + ruleEnabled +
        '}';
  }
}
