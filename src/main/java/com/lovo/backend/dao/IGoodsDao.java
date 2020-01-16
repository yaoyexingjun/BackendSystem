package com.lovo.backend.dao;

import com.lovo.backend.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 商品持久层接口
 */
public interface IGoodsDao extends CrudRepository<ProductEntity,Long> {
    /**
     * 查询全部商品
     * @return 商品集合
     */
    @Query("from ProductEntity pe order by pe.onStatus desc,pe.promotionStatus desc")
    public List<ProductEntity> findAllProduct();

    /**
     * 按商品编号查询商品
     * @param productCode 商品编号
     * @return 商品对象
     */
    @Query("from ProductEntity pe where pe.productCode = :productCode")
    public ProductEntity findProductByProductCode(@Param("productCode")String productCode);
}
