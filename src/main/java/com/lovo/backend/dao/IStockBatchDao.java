package com.lovo.backend.dao;

import com.lovo.backend.entity.StockBatchEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 库存批次持久层接口
 */
public interface IStockBatchDao extends CrudRepository<StockBatchEntity,Long> {
    /**
     * 查询全部库存批次
     * @return 库存批次集合
     */
    @Query("from StockBatchEntity sbe order by sbe.batch asc")
    public List<StockBatchEntity> findAllStockBatch(Pageable pageable);

    /**
     * 根据供货批次查询全部库存批次
     * @return 库存批次集合
     */
    @Query("from StockBatchEntity sbe where sbe.batch = :supplyBatch")
    public List<StockBatchEntity> findStockBatchBySupplyBatch(@Param("supplyBatch")String supplyBatch,Pageable pageable);

    /**
     * 根据供货批次查询库存批次记录数
     * @param supplyBatch 供货批次
     * @return 库存批次记录数
     */
    @Query("select count(sbe.stockBatchId) from StockBatchEntity sbe where sbe.batch = :supplyBatch")
    public int findAllCountBySupplyBatch(@Param("supplyBatch")String supplyBatch);
}
