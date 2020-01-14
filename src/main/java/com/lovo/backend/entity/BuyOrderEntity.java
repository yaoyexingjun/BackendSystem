package com.lovo.backend.entity;

import javax.persistence.*;

/**
 * 采购订单实体
 */
@Entity
@Table(name = "sys_purchase_order")
public class BuyOrderEntity {
    /**
     * 采购订单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "b_buyId")
    private long buyId;

    /**
     * 采购订单编号
     */
    @Column(name = "b_buyCode",length = 80)
    private String buyCode;

    /**
     * 采购订单下单时间
     */
    @Column(name = "b_buyDate",length = 16,columnDefinition = "date")
    private String buyDate;

    public long getBuyId() {
        return buyId;
    }

    public void setBuyId(long buyId) {
        this.buyId = buyId;
    }

    public String getBuyCode() {
        return buyCode;
    }

    public void setBuyCode(String buyCode) {
        this.buyCode = buyCode;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }
}
