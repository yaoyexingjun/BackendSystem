package com.lovo.backend.service;

import com.lovo.backend.entity.SupplyRecordEntity;

import java.util.List;

/**
 * 供货批次记录业务层接口
 */
public interface ISupplyRecordService {
    /**
     * 添加供货批次记录
     * @param supplyRecordEntity 供货批次记录对象
     */
    public void addSupplyRecord(SupplyRecordEntity supplyRecordEntity);

    /**
     * 根据供货批次号查询全部供货批次记录
     * @param supplyBatch 供货批次号
     * @return 供货批次记录集合
     */
    public List<SupplyRecordEntity> findAllSupplyRecordBySupplyBatch(String supplyBatch);
}
