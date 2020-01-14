package com.lovo.backend.entity;

import javax.persistence.*;

/**
 * 库存批次实体
 */
@Entity
@Table(name = "sys_stock_batch")
public class StockBatchEntity {
    /**
     * 库存批次id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sb_stockBatchId")
    private long stockBatchId;

    /**
     * 商品编号（类型首字母+编号，Eg:DZSP0001表示电子商品0001）
     */
    @Column(name = "sb_productCode",length = 80)
    private String productCode;

    /**
     * 供货批次
     */
    @Column(name = "sb_batch",length = 80)
    private String batch;

    /**
     * 采购数量
     */
    @Column(name = "sb_purchaseNum")
    private int purchaseNum;

    /**
     * 供应商名
     */
    @Column(name = "sb_supplierName",length = 80)
    private String supplierName;

    /**
     * 采购单价
     */
    @Column(name = "sb_price")
    private int price;

    /**
     * 采购总价
     */
    @Column(name = "sb_totalMoney")
    private int totalMoney;

    public long getStockBatchId() {
        return stockBatchId;
    }

    public void setStockBatchId(long stockBatchId) {
        this.stockBatchId = stockBatchId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(int purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
