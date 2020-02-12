package com.lovo.backend.service.impl;

import com.lovo.backend.dao.IGoodsDao;
import com.lovo.backend.entity.ProductEntity;
import com.lovo.backend.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品业务接口实现类
 */
@Service(value = "goodsService")
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private IGoodsDao goodsDao;

    @Transactional
    public void addProduct(ProductEntity productEntity) {
        if(goodsDao.findProductByProductCode(productEntity.getProductCode()) == null){
            goodsDao.save(productEntity);
        }
    }

    public List<ProductEntity> findAllProduct() {
        return goodsDao.findAllProduct();
    }

    public ProductEntity findProductByProductCode(String productCode) {
        return goodsDao.findProductByProductCode(productCode);
    }
}
