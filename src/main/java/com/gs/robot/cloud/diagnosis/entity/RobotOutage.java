package com.gs.robot.cloud.diagnosis.entity;

import java.util.Date;

public class RobotOutage extends EntityBase implements Comparable<RobotOutage>{

  private String productId;

  private Date recvTimestampT;

  private Date createdAtT;

  private Double mileageLeft;

  private Double mileageRight;

  private Double battery;

  private String modelType;

  public String getProductId() {
    return productId;
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

  public void setProductId(String productId) {
    this.productId = productId;
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
    return "RobotOutage{" +
        "productId='" + productId + '\'' +
        ", recvTimestampT=" + recvTimestampT +
        ", createdAtT=" + createdAtT +
        ", mileageLeft=" + mileageLeft +
        ", mileageRight=" + mileageRight +
        ", battery=" + battery +
        ", modelType='" + modelType + '\'' +
        '}';
  }

  @Override
  public int compareTo(RobotOutage o) {
    return  (int)(this.createdAtT.getTime() - o.getCreatedAtT().getTime());
  }
}
