package com.lovo.backend.entity;

import javax.persistence.*;

/**
 * 库存实体
 */
@Entity
@Table(name = "sys_stock")
public class StockEntity {
    /**
     * 库存id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_stockId")
    private long stockId;

    /**
     * 商品编号（类型首字母+编号，Eg:DZSP0001表示电子商品0001）
     */
    @Column(name = "s_productCode",length = 80)
    private String productCode;

    /**
     * 商品名
     */
    @Column(name = "s_productName",length = 80)
    private String productName;

    /**
     * 库存数量
     */
    @Column(name = "s_stockNum")
    private int stockNum;

    /**
     * 阈值
     */
    @Column(name = "s_threshold")
    private int threshold;

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
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

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
