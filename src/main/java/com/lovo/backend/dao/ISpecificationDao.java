package com.lovo.backend.dao;

import com.lovo.backend.entity.SpecificationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 规格持久层接口
 */
public interface ISpecificationDao extends CrudRepository<SpecificationEntity,Long> {
    /**
     * 根据商品编号查询商品的全部规格
     * @param productCode 商品编号
     * @return 规格集合
     */
    @Query("from SpecificationEntity se where se.productCode = :productCode")
    public List<SpecificationEntity> findAllSpecificationByProductCode(@Param("productCode")String productCode);
}
