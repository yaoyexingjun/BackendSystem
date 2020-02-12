package com.lovo.backend.service;

import com.lovo.backend.entity.ProductEntity;

import java.util.List;

/**
 * 商品业务层接口
 */
public interface IGoodsService {
    /**
     * 添加商品，如果该商品编号对应的商品已经存在则不做添加，反之则添加
     * @param productEntity 商品对象
     */
    public void addProduct(ProductEntity productEntity);

    /**
     * 查询全部商品
     * @return 商品集合
     */
    public List<ProductEntity> findAllProduct();

    /**
     * 按商品编号查询商品
     * @param productCode
     * @return 商品对象
     */
    public ProductEntity findProductByProductCode(String productCode);
}
