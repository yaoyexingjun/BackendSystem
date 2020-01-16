package com.lovo.backend.entity;

import javax.persistence.*;
import java.util.List;

/**
 * 用户退货实体
 */
@Entity
@Table(name = "sys_back_user")
public class BackUserEntity {
    /**
     * 退货id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ub_backUserId")
    private Long backUserId;
    /**
     * 退货订单编号
     */
    @Column(name = "ub_salesOrder",length = 80)
    private String salesOrder;
    /**
     * 退货总价
     */
    @Column(name ="ub_money" )
    private int money;
    /**
     * 退货时间
     */
    @Column(name = "un_backTime",length = 40,columnDefinition = "date")
    private String backTime;
    /**
     * 退货订单状态
     */
    @Column(name = "ub_tag",length = 48)
    private String tag;
    /**
     * 用户退货订单编号
     */
    @Column(name = "ub_ordrerNum",length = 48)
    private String orderNum;

    public Long getBackUserId() {
        return backUserId;
    }

    public void setBackUserId(Long backUserId) {
        this.backUserId = backUserId;
    }

    public String getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(String salesOrder) {
        this.salesOrder = salesOrder;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
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

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }


}
