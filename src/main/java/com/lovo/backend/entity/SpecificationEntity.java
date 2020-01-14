package com.lovo.backend.entity;

import javax.persistence.*;

/**
 * 规格实体
 */
@Entity
@Table(name = "sys_specification")
public class SpecificationEntity {
    /**
     * 规格id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_specificationId")
    private long specificationId;

    /**
     * 商品编号（类型首字母+编号，Eg:DZSP0001表示电子商品0001）
     */
    @Column(name = "s_productCode",length = 80)
    private String productCode;

    /**
     * 规格名（键）
     */
    @Column(name = "s_specificationKey",length = 32)
    private String specificationName;

    /**
     * 规格值（值）
     */
    @Column(name = "s_specificationValue",length = 64)
    private String specificationValue;

    public long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(long specificationId) {
        this.specificationId = specificationId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
    }

    public String getSpecificationValue() {
        return specificationValue;
    }

    public void setSpecificationValue(String specificationValue) {
        this.specificationValue = specificationValue;
    }
}
