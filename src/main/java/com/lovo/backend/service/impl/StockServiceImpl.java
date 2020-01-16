package com.lovo.backend.service.impl;

import com.lovo.backend.dao.IStockDao;
import com.lovo.backend.entity.StockEntity;
import com.lovo.backend.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 库存业务接口实现类
 */
@Service(value = "stockService")
public class StockServiceImpl implements IStockService {
    @Autowired
    private IStockDao stockDao;

    @Transactional
    public void addStock(StockEntity stockEntity) {
        if(stockDao.findStockByProductCode(stockEntity.getProductCode()) == null){
            stockDao.save(stockEntity);
        }else{
            stockDao.updateStockNumByProductCode(stockEntity.getStockNum(),stockEntity.getProductCode());
        }
    }
}
