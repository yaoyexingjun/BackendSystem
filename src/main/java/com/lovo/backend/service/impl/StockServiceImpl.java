package com.lovo.backend.service.impl;

import com.lovo.backend.dao.IStockDao;
import com.lovo.backend.entity.StockEntity;
import com.lovo.backend.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public int getTotalCount() {
        return (int) stockDao.count();
    }

    public int findAllPage() {
        int count = this.getTotalCount();
        int totalPage = (count + 5 - 1) / 5;
        return totalPage;
    }

    public List<StockEntity> findAllSupplyBatch(Pageable pageable) {
        return stockDao.findAllStock(pageable);
    }
}
