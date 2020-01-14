package com.lovo.backend.entity;

import javax.persistence.*;

/**
 * 供货批次实体
 */
@Entity
@Table(name = "sys_supply_batch")
public class SupplyBatchEntity {
    /**
     * 供货批次id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sb_supplyBatchId")
    private long supplyBatchId;

    /**
     * 供货时间
     */
    @Column(name = "sb_supplyTime",length = 16,columnDefinition = "date")
    private String supplyTime;

    /**
     * 供货批次
     */
    @Column(name = "sb_supplyBatch",length = 80)
    private String supplyBatch;

    /**
     * 总金额
     */
    @Column(name = "sb_totalPrice")
    private int totalPrice;

    /**
     * 供货进度（当前记录）
     */
    @Column(name = "sb_supplyRecord")
    private int supplyRecord;

    public long getSupplyBatchId() {
        return supplyBatchId;
    }

    public void setSupplyBatchId(long supplyBatchId) {
        this.supplyBatchId = supplyBatchId;
    }

    public String getSupplyTime() {
        return supplyTime;
    }

    public void setSupplyTime(String supplyTime) {
        this.supplyTime = supplyTime;
    }

    public String getSupplyBatch() {
        return supplyBatch;
    }

    public void setSupplyBatch(String supplyBatch) {
        this.supplyBatch = supplyBatch;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getSupplyRecord() {
        return supplyRecord;
    }

    public void setSupplyRecord(int supplyStatus) {
        this.supplyRecord = supplyStatus;
    }
}
