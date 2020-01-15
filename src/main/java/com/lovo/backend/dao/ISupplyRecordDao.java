package com.lovo.backend.dao;

import com.lovo.backend.entity.SupplyRecordEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 供货批次记录持久层接口
 */
public interface ISupplyRecordDao extends CrudRepository<SupplyRecordEntity,Long> {
    /**
     * 根据供货批次号查询全部供货批次记录
     * @param supplyBatch 供货批次号
     * @return 供货批次记录集合
     */
    @Query("from SupplyRecordEntity sre where sre.supplyBatch = :supplyBatch order by sre.supplyRecordTime")
    public List<SupplyRecordEntity> findAllSupplyRecordBySupplyBatch(@Param("supplyBatch")String supplyBatch);
}
