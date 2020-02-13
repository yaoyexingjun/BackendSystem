package com.lovo.backend.service.impl;

import com.lovo.backend.dao.IBackEndDao;
import com.lovo.backend.entity.BackEndEntity;
import com.lovo.backend.service.IBackEndService;
import com.lovo.backend.util.FormatDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后端退货业务接口实现类
 *q
 */
@Service
@Transactional
public class BackEndServiceImpl  implements IBackEndService {
    @Autowired
    private IBackEndDao backEndDao;

    @Override
    public void add(BackEndEntity backEndEntity) {
        backEndEntity.setSalesOrder(String.valueOf(System.currentTimeMillis()));
        String date= FormatDateUtil.getNowDate();
        backEndEntity.setBackTime(date);
        backEndDao.save(backEndEntity);
    }

    @Override
    public List<BackEndEntity> findAll() {
        return (List<BackEndEntity>) backEndDao.findAll();
    }

    @Override
    public void updateTagbysalesOrder(String salesOrder, String tag) {
         backEndDao.updateTagbysalesOrder(salesOrder,tag);
    }
}
