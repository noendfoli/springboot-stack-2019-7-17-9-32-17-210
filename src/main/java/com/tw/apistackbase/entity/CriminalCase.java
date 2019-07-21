package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
@Table(name ="criminial_case")
public class CriminalCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int caseId;
    @Column(nullable = false,length = 255)
    private String caseName;
    @Column(nullable = false)
    private Long time;
    @OneToOne(cascade = CascadeType.ALL)
    private SpecificInfo specificInfo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Procuratorate procuratorate;
    public SpecificInfo getSpecificInfo() {
        return specificInfo;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }

    public CriminalCase(int caseId, String caseName, Long time, SpecificInfo specificInfo) {
        this.caseId = caseId;
        this.caseName = caseName;
        this.time = time;
        this.specificInfo = specificInfo;
    }

    public void setSpecificInfo(SpecificInfo specificInfo) {
        this.specificInfo = specificInfo;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public CriminalCase(Long time) {
        this.time = time;
    }

    public CriminalCase(String caseName, Long time) {
        this.caseName = caseName;
        this.time = time;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public Long getTime() {
        return time;
    }

    public CriminalCase(String caseName, Long time, SpecificInfo specificInfo) {
        this.caseName = caseName;
        this.time = time;
        this.specificInfo = specificInfo;
    }

    public CriminalCase(int caseId, String caseName, Long time) {
        this.caseId = caseId;
        this.caseName = caseName;
        this.time = time;
    }

    public CriminalCase() {
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
