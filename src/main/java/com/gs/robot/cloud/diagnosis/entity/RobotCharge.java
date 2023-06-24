package com.gs.robot.cloud.diagnosis.entity;

import java.util.Date;

public class RobotCharge extends EntityBase implements Comparable<RobotCharge>{

  private String productId;

  private Date recvTimestampT;

  private Date createdAtT;

  private Boolean chargerStatus;

  private Double battery;

  private String modelType;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
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

  public Boolean getChargerStatus() {
    return chargerStatus;
  }

  public void setChargerStatus(Boolean chargerStatus) {
    this.chargerStatus = chargerStatus;
  }

  public Double getBattery() {
    return battery;
  }

  public void setBattery(Double battery) {
    this.battery = battery;
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
    return "RobotCharge{" +
        "productId='" + productId + '\'' +
        ", recvTimestampT=" + recvTimestampT +
        ", createdAtT=" + createdAtT +
        ", chargerStatus=" + chargerStatus +
        ", battery=" + battery +
        ", modelType='" + modelType + '\'' +
        '}';
  }

  @Override
  public int compareTo(RobotCharge o) {
    return  (int)(this.createdAtT.getTime() - o.getCreatedAtT().getTime());
  }
}

