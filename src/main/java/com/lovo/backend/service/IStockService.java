package com.lovo.backend.service;

import com.lovo.backend.entity.StockEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 库存业务层接口
 */
public interface IStockService {
    /**
     * 添加库存，如果该商品编号对应的库存已经存在，则添加库存数量，反之则添加库存
     * @param stockEntity 库存对象
     */
    public void addStock(StockEntity stockEntity);

    /**
     * 查询库存总页数
     * @return 总页数
     */
    public int findAllPage();

    /**
     * 查询全部库存
     * @return 库存集合
     */
    public List<StockEntity> findAllSupplyBatch(Pageable pageable);
}
