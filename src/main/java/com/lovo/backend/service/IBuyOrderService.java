package com.lovo.backend.service;

import com.lovo.backend.entity.BuyOrderEntity;

/**
 * 采购订单业务层接口
 */
public interface IBuyOrderService {
    /**
     * 添加采购订单
     * @param buyOrderEntity 采购订单对象
     */
    public void addBuyOrder(BuyOrderEntity buyOrderEntity);
}
