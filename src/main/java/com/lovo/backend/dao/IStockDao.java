package com.lovo.backend.dao;

import com.lovo.backend.entity.StockEntity;
import com.lovo.backend.entity.SupplyBatchEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 库存持久层接口
 */
public interface IStockDao extends CrudRepository<StockEntity,Long> {
    /**
     * 查询全部库存，以库存量升序显示
     * @return 供货批次集合
     */
    @Query("from StockEntity se order by se.stockNum asc")
    public List<StockEntity> findAllStock(Pageable pageable);

    /**
     * 按商品编号查询库存
     * @param productCode 商品编号
     * @return 库存对象
     */
    @Query("from StockEntity se where se.productCode = :productCode")
    public StockEntity findStockByProductCode(@Param("productCode")String productCode);

    /**
     * 根据商品编号修改对应库存的库存数量
     * @param stockNum 库存数量
     * @param productCode 商品编号
     */
    @Query("update StockEntity se set se.stockNum = se.stockNum + :stockNum where se.productCode = :productCode")
    @Modifying
    public void updateStockNumByProductCode(@Param("stockNum")int stockNum,@Param("productCode")String productCode);

    /**
     * 根据商品编号修改库存表里的阈值
     * @param productCode 商品编号
     * @param threshold 阈值
     */
    @Query("update StockEntity se set se.threshold = ?2 where se.productCode = ?1")
    public void updateThresholdByProductCode(String productCode,int threshold);
}
