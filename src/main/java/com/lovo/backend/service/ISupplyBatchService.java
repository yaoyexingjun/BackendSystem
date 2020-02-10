package com.lovo.backend.service;

import com.lovo.backend.entity.SupplyBatchEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 供货批次业务层接口
 */
public interface ISupplyBatchService {
    /**
     * 添加供货批次
     * @param supplyBatchEntity 供货批次对象
     */
    public void addSupplyBatch(SupplyBatchEntity supplyBatchEntity);

    /**
     * 查询全部供货批次
     * @return 供货批次集合
     */
    public List<SupplyBatchEntity> findAllSupplyBatch(Pageable pageable);

    /**
     * 根据供货批次id查询单个供货批次
     * @param supplyBatchId 供货批次id
     * @return 供货批次对象
     */
    public SupplyBatchEntity findSupplyBatchById(long supplyBatchId);

    /**
     * 根据供货批次id修改供货批次进度
     * @param supplyBatchId 供货批次id
     * @param supplyRecord 供货批次状态
     */
    public void updateSupplyRecord(long supplyBatchId,int supplyRecord);

    /**
     * 获取总记录条数
     * @return 总记录条数
     */
    public int getTotalCount();

    /**
     * 查询供货批次总页数
     * @return 总页数
     */
    public int findAllPage();
}
