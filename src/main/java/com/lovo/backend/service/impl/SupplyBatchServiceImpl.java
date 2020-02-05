package com.lovo.backend.service.impl;

import com.lovo.backend.dao.ISupplyBatchDao;
import com.lovo.backend.entity.SupplyBatchEntity;
import com.lovo.backend.entity.SupplyRecordEntity;
import com.lovo.backend.service.ISupplyBatchService;
import com.lovo.backend.service.ISupplyRecordService;
import com.lovo.backend.util.FormatDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

/**
 * 供货批次业务接口实现类
 */
@Service(value = "supplyBatchService")
public class SupplyBatchServiceImpl implements ISupplyBatchService {
    @Autowired
    private ISupplyBatchDao supplyBatchDao;
    @Autowired
    private ISupplyRecordService supplyRecordService;

    @Transactional
    public void addSupplyBatch(SupplyBatchEntity supplyBatchEntity) {
        //保存供货批次
        supplyBatchDao.save(supplyBatchEntity);

        //创建供货批次记录
        SupplyRecordEntity supplyRecordEntity = new SupplyRecordEntity();
        supplyRecordEntity.setSupplyBatch(supplyBatchEntity.getSupplyBatch());
        supplyRecordEntity.setSupplyRecordTime(FormatDateUtil.getNowDate());
        supplyRecordEntity.setSupplyRecord("已验收");

        //保存供货批次记录
        supplyRecordService.addSupplyRecord(supplyRecordEntity);
    }

    public List<SupplyBatchEntity> findAllSupplyBatch(Pageable pageable) {
        return supplyBatchDao.findAllSupplyBatch(pageable);
    }

    public SupplyBatchEntity findSupplyBatchById(long supplyBatchId) {
        Optional<SupplyBatchEntity> supplyBatchEntity = supplyBatchDao.findById(supplyBatchId);
        return supplyBatchEntity.get();
    }

    @Transactional
    public void updateSupplyRecord(long supplyBatchId, int supplyRecord) {
        //修改供货批次状态
        supplyBatchDao.updateSupplyRecord(supplyBatchId,supplyRecord);

        //查询供货批次
        SupplyBatchEntity supplyBatchEntity = this.findSupplyBatchById(supplyBatchId);

        //创建供货批次记录
        SupplyRecordEntity supplyRecordEntity = new SupplyRecordEntity();
        supplyRecordEntity.setSupplyBatch(supplyBatchEntity.getSupplyBatch());
        supplyRecordEntity.setSupplyRecordTime(FormatDateUtil.getNowDate());
        supplyRecordEntity.setSupplyRecord("已入库");

        //保存供货批次记录
        supplyRecordService.addSupplyRecord(supplyRecordEntity);
    }

    public int getTotalCount() {
        return (int) supplyBatchDao.count();
    }

}
