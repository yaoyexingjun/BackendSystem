package com.lovo.backend.entity;

import javax.persistence.*;

/**
 * 用户订单状态实体
 */
@Entity
@Table(name = "sys_user_order_status")
public class UserOrderStatusEntity {
    /**
     * 用户订单状态id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderTrace_Id")
    private long orderTraceId;

    /**
     * 订单编号
     */
    @Column(name = "order_number",length = 48)
    private String orderNumber;

    /**
     * 记录时间
     */
    @Column(name = "writeTime",length = 48)
    private String writeTime;

    /**
     * 执行操作
     */
    @Column(name = "action",length = 80)
    private String action;

    public long getOrderTraceId() {
        return orderTraceId;
    }

    public void setOrderTraceId(long orderTraceId) {
        this.orderTraceId = orderTraceId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(String writeTime) {
        this.writeTime = writeTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
