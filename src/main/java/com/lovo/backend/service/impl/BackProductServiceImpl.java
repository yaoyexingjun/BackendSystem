package com.lovo.backend.service.impl;

import com.lovo.backend.dao.IBackProductDao;
import com.lovo.backend.entity.BackProductEntity;
import com.lovo.backend.service.IBackProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BackProductServiceImpl implements IBackProductService {
    @Autowired
    private IBackProductDao backProductDao;
    public void add(BackProductEntity backProductEntity) {
        backProductDao.save(backProductEntity);
    }
}
