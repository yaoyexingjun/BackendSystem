package com.lovo.backend.entity;

import javax.persistence.*;

/**
 * 商品表实体类
 */
@Entity
@Table(name = "sys_Back_product")
public class BackProductEntity {
    /**
     * 商品id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="rp_id" )
    private Integer BackProductId;
    /**
     * 退货商品名
     */
    @Column(name ="rp_commodityName",length = 80)
    private String commodityName;
    /**
     * 退货数量
     */
    @Column(name ="rp_quantity",length = 80)
    private int quantity;
    /**
     * 退货商品单价
     */
    @Column(name ="rp_price",length = 80)
    private int price;
    /**
     * 退货商品编号
     */
    @Column(name ="rp_productCode",length = 80)
    private String productCode;
    /**
     * 后端退货单对象
     */
    @ManyToOne
    @JoinColumn(name="eb_backEndId")
    private BackEndEntity backEndEntity;
    /**
     * 用户退货单对象
     */
    @ManyToOne
    @JoinColumn(name="ub_backUserId")
    private BackUserEntity backUserEntity;

    public Integer getBackProductId() {
        return BackProductId;
    }

    public void setBackProductId(Integer backProductId) {
        BackProductId = backProductId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BackEndEntity getBackEndEntity() {
        return backEndEntity;
    }

    public void setBackEndEntity(BackEndEntity backEndEntity) {
        this.backEndEntity = backEndEntity;
    }

    public BackUserEntity getBackUserEntity() {
        return backUserEntity;
    }

    public void setBackUserEntity(BackUserEntity backUserEntity) {
        this.backUserEntity = backUserEntity;
    }
}
