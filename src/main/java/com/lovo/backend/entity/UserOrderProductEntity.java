package com.lovo.backend.entity;

import javax.persistence.*;

/**
 * 用户订单商品实体
 */
@Entity
@Table(name = "user_order_product")
public class UserOrderProductEntity {
    /**
     * 用户订单商品id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id")
    private long goodsId;

    /**
     * 订单编号
     */
    @Column(name = "order_Number",length = 48)
    private String orderNumber;

    /**
     * 单价
     */
    @Column(name = "goods_price")
    private double goodsPrice;

    /**
     * 数量
     */
    @Column(name = "goods_num",length = 48)
    private int goodsNum;

    /**
     * 总计
     */
    @Column(name = "goods_money")
    private double goodsMoney;

    /**
     * 商品编号
     */
    @Column(name = "goods_number",length = 80)
    private String goodsNumber;

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public double getGoodsMoney() {
        return goodsMoney;
    }

    public void setGoodsMoney(double goodsMoney) {
        this.goodsMoney = goodsMoney;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }
}
