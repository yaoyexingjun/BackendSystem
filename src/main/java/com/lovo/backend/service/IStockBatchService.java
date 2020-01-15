package com.lovo.backend.service;

import com.lovo.backend.entity.StockBatchEntity;

import java.util.List;

/**
 * 库存批次业务层接口
 */
public interface IStockBatchService {
    /**
     * 添加库存批次
     * @param stockBatchEntity 库存批次对象
     */
    public void addStockBatch(StockBatchEntity stockBatchEntity);

    /**
     * 查询全部库存批次
     * @return 库存批次集合
     */
    public List<StockBatchEntity> findAllStockBatch();

    /**
     * 根据供货批次查询全部库存批次
     * @return 库存批次集合
     */
    public List<StockBatchEntity> findStockBatchBySupplyBatch(String supplyBatch);
}
