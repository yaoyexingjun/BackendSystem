package com.lovo.backend.service;

import com.lovo.backend.entity.BuyOrderProductEntity;

import java.util.List;

/**
 * 采购订单商品业务层接口
 */
public interface IBuyOrderProductService {
    /**
     * 添加采购订单商品
     * @param buyOrderProductEntity 采购订单商品对象
     */
    public void addBuyOrderProduct(BuyOrderProductEntity buyOrderProductEntity);

    /**
     * 查询全部采购订单商品
     * @return 采购订单商品集合
     */
    public List<BuyOrderProductEntity> findAllBuyOrderProduct();
}
