package com.lovo.backend.dao;

import com.lovo.backend.entity.SupplyBatchEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 供货批次持久层接口
 */
public interface ISupplyBatchDao extends CrudRepository<SupplyBatchEntity,Long> {
    /**
     * 查询全部供货批次记录，分组（0已验收，1已入库）升序显示
     * @return 供货批次集合
     */
    @Query("from SupplyBatchEntity sbe order by sbe.supplyRecord asc")
    public List<SupplyBatchEntity> findAllSupplyBatch();

    /**
     * 按供货批次id修改供货批次的进度
     * @param supplyBatchId 供货批次id
     * @param supplyRecord 供货批次进度
     */
    @Query("update SupplyBatchEntity sbe set sbe.supplyRecord = :supplyRecord where sbe.supplyBatchId = :supplyBatchId")
    @Modifying
    public void updateSupplyRecord(@Param("supplyBatchId")long supplyBatchId,@Param("supplyRecord")int supplyRecord);
}
