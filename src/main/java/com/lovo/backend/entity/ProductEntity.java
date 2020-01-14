package com.lovo.backend.entity;

import javax.persistence.*;

/**
 * 商品实体
 */
@Entity
@Table(name = "sys_product")
public class ProductEntity {
    /**
     * 商品id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_productId")
    private long productId;

    /**
     * 商品编号（类型首字母+编号，Eg:DZSP0001表示电子商品0001）
     */
    @Column(name = "p_productCode",length = 80)
    private String productCode;

    /**
     * 商品名
     */
    @Column(name = "p_productName",length = 80)
    private String productName;

    /**
     * 商品类型
     */
    @Column(name = "p_productType",length = 32)
    private String productType;

    /**
     * 上架状态（上架1，下架2，待上架0，默认0）
     */
    @Column(name = "p_onStatus")
    private int onStatus;

    /**
     * 单价
     */
    @Column(name = "p_price")
    private double price;

    /**
     * 预售状态（0：非预售状态，1：预售状态，默认0）
     */
    @Column(name = "p_presellStatus")
    private int presellStatus;

    /**
     * 促销状态（0：非促销状态，1：促销状态，默认0）
     */
    @Column(name = "p_promotionStatus")
    private int promotionStatus;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getOnStatus() {
        return onStatus;
    }

    public void setOnStatus(int onStatus) {
        this.onStatus = onStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPresellStatus() {
        return presellStatus;
    }

    public void setPresellStatus(int presellStatus) {
        this.presellStatus = presellStatus;
    }

    public int getPromotionStatus() {
        return promotionStatus;
    }

    public void setPromotionStatus(int promotionStatus) {
        this.promotionStatus = promotionStatus;
    }
}
