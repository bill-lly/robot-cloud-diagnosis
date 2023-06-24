package com.gs.robot.cloud.diagnosis.entity;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

public class IncidentEvent extends EntityBase {

  @JsonProperty("eventId")
  private String eventId;

  @JsonProperty("subjectId")
  private String subjectId;

  @JsonProperty("subjectType")
  private String subjectType;

  @JsonProperty("subjectModel")
  private String subjectModel;

  @JsonProperty("incidentCode")
  private String incidentCode;

  @JsonProperty("incidentStartTime")
  private String incidentStartTime;

  @JsonProperty("eventTime")
  private String eventTime;

  @JsonProperty("finalized")
  private Boolean finalized;

  @JsonProperty("cleanType")
  private String cleanType;

  @JsonIgnore
  private String status;

  @JsonIgnore
  private String alias;

  @JsonIgnore
  private String softwareVersion;

  @JsonIgnore
  private String customerCode;

  private String maintenanceRegionCode;

  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public String getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(String subjectId) {
    this.subjectId = subjectId;
  }

  public String getSubjectType() {
    return subjectType;
  }

  public void setSubjectType(String subjectType) {
    this.subjectType = subjectType;
  }

  public String getSubjectModel() {
    return subjectModel;
  }

  public void setSubjectModel(String subjectModel) {
    this.subjectModel = subjectModel;
  }

  public String getIncidentCode() {
    return incidentCode;
  }

  public void setIncidentCode(String incidentCode) {
    this.incidentCode = incidentCode;
  }

  public String getIncidentStartTime() {
    return incidentStartTime;
  }

  public void setIncidentStartTime(String incidentStartTime) {
    this.incidentStartTime = incidentStartTime;
  }

  public String getEventTime() {
    return eventTime;
  }

  public void setEventTime(String eventTime) {
    this.eventTime = eventTime;
  }

  public Boolean getFinalized() {
    return finalized;
  }

  public void setFinalized(Boolean finalized) {
    this.finalized = finalized;
  }

  public String getCleanType() {
    return cleanType;
  }

  public void setCleanType(String cleanType) {
    this.cleanType = cleanType;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public String getSoftwareVersion() {
    return softwareVersion;
  }

  public void setSoftwareVersion(String softwareVersion) {
    this.softwareVersion = softwareVersion;
  }

  public String getCustomerCode() {
    return customerCode;
  }

  public void setCustomerCode(String customerCode) {
    this.customerCode = customerCode;
  }

  public String getMaintenanceRegionCode() {
    return maintenanceRegionCode;
  }

  public void setMaintenanceRegionCode(String maintenanceRegionCode) {
    this.maintenanceRegionCode = maintenanceRegionCode;
  }

  @Override
  public String getKey() {
    return getSubjectId();
  }

  @Override
  public String toString() {
    return "IncidentEvent{" +
        "eventId='" + eventId + '\'' +
        ", subjectId='" + subjectId + '\'' +
        ", subjectType='" + subjectType + '\'' +
        ", subjectModel='" + subjectModel + '\'' +
        ", incidentCode='" + incidentCode + '\'' +
        ", incidentStartTime='" + incidentStartTime + '\'' +
        ", eventTime='" + eventTime + '\'' +
        ", finalized=" + finalized +
        ", cleanType='" + cleanType + '\'' +
        ", status='" + status + '\'' +
        ", alias='" + alias + '\'' +
        ", softwareVersion='" + softwareVersion + '\'' +
        ", customerCode='" + customerCode + '\'' +
        ", maintenanceRegionCode='" + maintenanceRegionCode + '\'' +
        '}';
  }
}
