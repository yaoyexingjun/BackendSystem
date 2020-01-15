package com.lovo.backend.service;

import com.lovo.backend.entity.ProductEntity;

import java.util.List;

public interface IProductService {
    /**
     * 查询前端所有商品
     * @param page 页数
     * @return
     */
    public List<ProductEntity> findAll(int page);


    /**
     * 动态查询,根据类型和上下架状态查询
     * @param state 上下架状态
     * @param producttpye 商品类型
     * @param page 页数
     * @return
     */
    public List<ProductEntity> findState(int state,String producttpye,int page);

    /**
     * 查询前端商品总页数
     * @return
     */
    public int findPage();
    /**
     * 动态查询,根据类型和上下架状态查询页数
     * @param state 上下架状态
     * @param producttpye 商品类型
     * @return
     */
    public int findStatePage(int state,String producttpye);

    /**
     * 修改上下架状态
     * @param state 上下架状态
     * @param code 产品编号
     */
    public void updateState(int state,String code);
}
