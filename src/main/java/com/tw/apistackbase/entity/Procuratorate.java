package com.tw.apistackbase.entity;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name ="procuratorate")
public class Procuratorate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int procuratorateId;
    @Column(nullable = false,length = 50,unique = true)
    private String procuratorateName;

    public Procuratorate() {
    }

    public Procuratorate(int procuratorateId, String procuratorateName) {
        this.procuratorateId = procuratorateId;
        this.procuratorateName = procuratorateName;
    }

    public Procuratorate(String procuratorateName) {
        this.procuratorateName = procuratorateName;
    }

    public int getProcuratorateId() {
        return procuratorateId;
    }

    public void setProcuratorateId(int procuratorateId) {
        this.procuratorateId = procuratorateId;
    }

    public String getProcuratorateName() {
        return procuratorateName;
    }

    public void setProcuratorateName(String procuratorateName) {
        this.procuratorateName = procuratorateName;
    }
}
