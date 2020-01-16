package com.lovo.backend.service.impl;

import com.lovo.backend.dao.IBuyOrderDao;
import com.lovo.backend.entity.BuyOrderEntity;
import com.lovo.backend.service.IBuyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 采购订单业务接口实现类
 */
@Service(value = "buyOrderService")
public class BuyOrderServiceImpl implements IBuyOrderService {
    @Autowired
    private IBuyOrderDao buyOrderDao;

    @Transactional
    public void addBuyOrder(BuyOrderEntity buyOrderEntity) {
        buyOrderDao.save(buyOrderEntity);
    }
}
