package com.lovo.backend.entity;

import javax.persistence.*;

/**
 * 用户订单实体
 */
@Entity
@Table(name = "sys_user_order")
public class UserOrderEntity {
    /**
     * 用户订单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_Id")
    private long orderId;

    /**
     * 用户订单编号
     */
    @Column(name = "order_Number",length = 48)
    private String orderNumber;

    /**
     * 订单资金
     */
    @Column(name = "order_money")
    private double orderMoney;

    /**
     * 用户编号
     */
    @Column(name = "order_user_id",length = 48)
    private String orderUserId;

    /**
     * 下单时间
     */
    @Column(name = "order_Date",length = 48)
    private String orderDate;

    /**
     * 收货人
     */
    @Column(name = "order_UserName",length = 32)
    private String orderUserName;

    /**
     * 收货人电话
     */
    @Column(name = "order_phone",length = 32)
    private String orderPhone;

    /**
     * 收货地址
     */
    @Column(name = "order_address",length = 80)
    private String orderAddress;

    /**
     * 订单状态，默认为0（结算但未到货），1（到货），2（退货）
     */
    @Column(name = "order_tag")
    private int orderTag;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(String orderUserId) {
        this.orderUserId = orderUserId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public int getOrderTag() {
        return orderTag;
    }

    public void setOrderTag(int orderTag) {
        this.orderTag = orderTag;
    }
}
