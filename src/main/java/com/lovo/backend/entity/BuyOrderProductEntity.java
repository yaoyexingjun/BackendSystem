package com.lovo.backend.entity;

import javax.persistence.*;

/**
 * 采购订单商品实体
 */
@Entity
@Table(name = "sys_purchase_order_product")
public class BuyOrderProductEntity {
    /**
     * 采购订单商品id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bp_id")
    private long buyProductId;

    /**
     * 采购订单编号
     */
    @Column(name = "bp_buyCode",length = 80)
    private String buyCode;

    /**
     * 商品编号（类型首字母+编号，Eg:DZSP0001表示电子商品0001）
     */
    @Column(name = "bp_productCode",length = 80)
    private String productCode;

    /**
     * 采购数量
     */
    @Column(name = "bp_buyNum")
    private int buyNum;

    public long getBuyProductId() {
        return buyProductId;
    }

    public void setBuyProductId(long buyProductId) {
        this.buyProductId = buyProductId;
    }

    public String getBuyCode() {
        return buyCode;
    }

    public void setBuyCode(String buyCode) {
        this.buyCode = buyCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }
}
