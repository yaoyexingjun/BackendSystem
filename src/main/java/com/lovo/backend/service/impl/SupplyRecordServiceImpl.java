package com.lovo.backend.service.impl;

import com.lovo.backend.dao.ISupplyRecordDao;
import com.lovo.backend.entity.SupplyRecordEntity;
import com.lovo.backend.service.ISupplyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 供货批次记录业务接口实现类
 */
@Service(value = "supplyRecordService")
public class SupplyRecordServiceImpl implements ISupplyRecordService {
    @Autowired
    private ISupplyRecordDao supplyRecordDao;

    @Transactional
    public void addSupplyRecord(SupplyRecordEntity supplyRecordEntity) {
        supplyRecordDao.save(supplyRecordEntity);
    }

    public List<SupplyRecordEntity> findAllSupplyRecordBySupplyBatch(String supplyBatch) {
        return supplyRecordDao.findAllSupplyRecordBySupplyBatch(supplyBatch);
    }

}
