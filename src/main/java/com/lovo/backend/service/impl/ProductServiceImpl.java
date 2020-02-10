package com.lovo.backend.service.impl;

import com.lovo.backend.dao.IProductDao;
import com.lovo.backend.entity.ProductEntity;
import com.lovo.backend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "productService")
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

    /**
     * 查询前端所有商品
     *
     * @param page 页数
     * @return
     */
    @Override
    public List<ProductEntity> findAll(int page) {
        Pageable page2 = PageRequest.of(page - 1, 5);
        List<ProductEntity> list = productDao.findAll(page2);
        return list;
    }

    /**
     * 动态查询,根据类型和上下架状态产品
     *
     * @param state       上下架状态
     * @param producttpye 商品类型
     * @param page        页数
     * @return
     */
    @Override
    public List<ProductEntity> findState(int state, String producttpye, int page) {
        if (producttpye == null || producttpye == "" && state != 0) {
            Pageable page2 = PageRequest.of(page - 1, 5);
            return productDao.findStateAndPage(state, page2);
        } else if (producttpye == null || producttpye == "" && state == 0) {
            Pageable page2 = PageRequest.of(page - 1, 5);
            return productDao.findAll(page2);
        } else if(producttpye != null || producttpye != "" && state != 0){
            Pageable page2 = PageRequest.of(page - 1, 5);
            return productDao.findByProductType(producttpye,page2);
        }

        else {
            Pageable page2 = PageRequest.of(page - 1, 5);
            return productDao.findByState(state, producttpye, page2);
        }

    }

    /**
     * 查询前端商品总页数
     *
     * @return
     */
    @Override
    public int findPage() {
        int count = productDao.findAllCount();
        int totalPage = (count + 5 - 1) / 5;
        return totalPage;
    }

    /**
     * 动态查询,根据类型和上下架状态查询页数
     *
     * @param state       上下架状态
     * @param producttpye 商品类型
     * @return
     */
    @Override
    public int findStatePage(int state, String producttpye) {
        if(producttpye == null || producttpye == ""&&state==0) {
            int count = productDao.findAllCount();
            int totalPage = (count + 5 - 1) / 5;
            return totalPage;
        }
        else  if(producttpye == null || producttpye == "") {
            int count = productDao.findState(state);
            int totalPage = (count + 5 - 1) / 5;
            return totalPage;
        }else if(producttpye != null || producttpye != ""&&state==0){
            int count = productDao.findProductTpyeCount(producttpye);
            int totalPage = (count + 5 - 1) / 5;
            return totalPage;
        }
        else {
            int count = productDao.findByStateCount(state, producttpye);
            int totalPage = (count + 5 - 1) / 5;
            return totalPage;
        }

    }

    /**
     * 修改上下架状态
     *
     * @param state 上下架状态
     * @param code  产品编号
     */
    @Override
    public void updateState(int state, String code) {
        productDao.updateState(state, code);
    }
}
