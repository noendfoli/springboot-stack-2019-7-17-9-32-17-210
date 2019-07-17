package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
@Table(name ="specific_info")
public class SpecificInfo {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int speInfoId;
   @Column(nullable = false,length = 255)
   private String  objectiveInfo;
    @Column(nullable = false,length = 255)
   private String subjectiveInfo;

    public SpecificInfo() {
    }

    public SpecificInfo(int speInfoId, String objectiveInfo, String subjectiveInfo) {
        this.speInfoId = speInfoId;
        this.objectiveInfo = objectiveInfo;
        this.subjectiveInfo = subjectiveInfo;
    }

    public SpecificInfo(String objectiveInfo, String subjectiveInfo) {
        this.objectiveInfo = objectiveInfo;
        this.subjectiveInfo = subjectiveInfo;
    }

    public int getSpeInfoId() {
        return speInfoId;
    }

    public void setSpeInfoId(int speInfoId) {
        this.speInfoId = speInfoId;
    }

    public String getObjectiveInfo() {
        return objectiveInfo;
    }

    public void setObjectiveInfo(String objectiveInfo) {
        this.objectiveInfo = objectiveInfo;
    }

    public String getSubjectiveInfo() {
        return subjectiveInfo;
    }

    public void setSubjectiveInfo(String subjectiveInfo) {
        this.subjectiveInfo = subjectiveInfo;
    }
}
