package com.lovo.backend.entity;

import javax.persistence.*;

/**
 * 供货记录实体
 */
@Entity
@Table(name = "sys_supply_record")
public class SupplyRecordEntity {
    /**
     * 供货记录id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sr_supplyRecordId")
    private long supplyRecordId;

    /**
     * 供货记录时间
     */
    @Column(name = "sr_supplyRecordTime",length = 16,columnDefinition = "date")
    private String supplyRecordTime;

    /**
     * 供货进度（历史记录）
     */
    @Column(name = "sr_supplyRecord",length = 32)
    private String supplyRecord;

    /**
     * 供货批次
     */
    @Column(name = "sb_supplyBatch",length = 80)
    private String supplyBatch;

    public long getSupplyRecordId() {
        return supplyRecordId;
    }

    public void setSupplyRecordId(long supplyRecordId) {
        this.supplyRecordId = supplyRecordId;
    }

    public String getSupplyRecordTime() {
        return supplyRecordTime;
    }

    public void setSupplyRecordTime(String supplyRecordTime) {
        this.supplyRecordTime = supplyRecordTime;
    }

    public String getSupplyRecord() {
        return supplyRecord;
    }

    public void setSupplyRecord(String supplyRecord) {
        this.supplyRecord = supplyRecord;
    }

    public String getSupplyBatch() {
        return supplyBatch;
    }

    public void setSupplyBatch(String supplyBatch) {
        this.supplyBatch = supplyBatch;
    }
}
