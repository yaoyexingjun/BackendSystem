package com.lovo.backend.entity;

import javax.persistence.*;

/**
 * 后端退货实体类
 */
@Entity
@Table(name = "sys_back_end")
public class BackEndEntity {
    /**
     * 后端退货id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ideb_backEndId",length = 40)
    private long backEndId;
    /**
     * 退货订单编号
     */
    @Column(name = "eb_salesOrder",length = 80)
    private String salesOrder;
    /**
     * 总价
     */
    @Column(name = "eb_money",length =48)
    private Integer money;
    /**
     * 退货时间
     */
    @Column(name = "eb_backTime",length = 40,columnDefinition = "datetime")
    private String backTime;
    /**
     * 退货订单状态
     */
    @Column(name = "eb_tag",length = 48)
    private String tag;
    /**
     * 进货批次编号
     */
    @Column(name = "eb_batch",length = 80)
    private String batch;
    /**
     * 供应商名
     */
    @Column(name = "eb_supplyName",length = 80)
    private String supplyName;

    public long getBackEndId() {
        return backEndId;
    }

    public void setBackEndId(long backEndId) {
        this.backEndId = backEndId;
    }

    public String getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(String salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getBackTime() {
        return backTime;
    }

    public void setBackTime(String backTime) {
        this.backTime = backTime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }
}
