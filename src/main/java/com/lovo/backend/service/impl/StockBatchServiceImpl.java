package com.lovo.backend.service.impl;

import com.lovo.backend.dao.IStockBatchDao;
import com.lovo.backend.entity.StockBatchEntity;
import com.lovo.backend.service.IStockBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 库存批次业务接口实现类
 */
@Service(value = "stockBatchService")
public class StockBatchServiceImpl implements IStockBatchService {
    @Autowired
    private IStockBatchDao stockBatchDao;

    @Transactional
    public void addStockBatch(StockBatchEntity stockBatchEntity) {
        stockBatchDao.save(stockBatchEntity);
    }

    public List<StockBatchEntity> findAllStockBatch() {
        return stockBatchDao.findAllStockBatch();
    }

    public List<StockBatchEntity> findStockBatchBySupplyBatch(String supplyBatch) {
        return stockBatchDao.findStockBatchBySupplyBatch(supplyBatch);
    }

}
