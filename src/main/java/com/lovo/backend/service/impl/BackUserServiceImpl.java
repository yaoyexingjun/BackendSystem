package com.lovo.backend.service.impl;

import com.lovo.backend.dao.IBackUserDao;
import com.lovo.backend.entity.BackUserEntity;
import com.lovo.backend.service.IBackUserService;
import com.lovo.backend.util.FormatDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 用户退货业务接口实现类
 */
@Service
@Transactional
public class BackUserServiceImpl implements IBackUserService {
    @Autowired
    private IBackUserDao backUserDao;
    @Override
    public void add(BackUserEntity backUserEntity) {

        String date = FormatDateUtil.getNowDate();
        backUserEntity.setBackTime(date);
        backUserEntity.setSalesOrder(String.valueOf(System.currentTimeMillis()));
        backUserDao.save(backUserEntity);
    }

    @Override
    public List<BackUserEntity> findAll() {

        return (List<BackUserEntity>) backUserDao.findAll();
    }

    @Override
    public void update(String orderNum, String tag) {
        backUserDao.update(orderNum,tag);
    }
}
