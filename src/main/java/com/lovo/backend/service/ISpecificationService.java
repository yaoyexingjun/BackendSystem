package com.lovo.backend.service;

import com.lovo.backend.entity.SpecificationEntity;

import java.util.List;

/**
 * 规格业务层接口
 */
public interface ISpecificationService {
    /**
     * 添加规格
     * @param specificationEntity 规格对象
     */
    public void addSpecification(SpecificationEntity specificationEntity);

    /**
     * 根据商品编号查询商品的全部规格
     * @param productCode 商品编号
     * @return 规格集合
     */
    public List<SpecificationEntity> findAllSpecificationByProductCode(String productCode);
}
