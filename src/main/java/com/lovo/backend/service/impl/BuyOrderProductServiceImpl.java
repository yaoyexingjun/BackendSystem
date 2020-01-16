package com.lovo.backend.service.impl;

import com.lovo.backend.dao.IBuyOrderProductDao;
import com.lovo.backend.entity.BuyOrderProductEntity;
import com.lovo.backend.service.IBuyOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 采购订单商品业务接口实现类
 */
@Service(value = "buyOrdrProductService")
public class BuyOrderProductServiceImpl implements IBuyOrderProductService {
    @Autowired
    private IBuyOrderProductDao buyOrderProductDao;

    @Transactional
    public void addBuyOrderProduct(BuyOrderProductEntity buyOrderProductEntity) {
        buyOrderProductDao.save(buyOrderProductEntity);
    }

    public List<BuyOrderProductEntity> findAllBuyOrderProduct() {
        return buyOrderProductDao.findAllBuyOrderProduct();
    }
}
