package com.lovo.backend.service;

import com.lovo.backend.entity.StockEntity;

/**
 * 库存业务层接口
 */
public interface IStockService {
    /**
     * 添加库存，如果该商品编号对应的库存已经存在，则添加库存数量，反之则添加库存
     * @param stockEntity 库存对象
     */
    public void addStock(StockEntity stockEntity);
}
