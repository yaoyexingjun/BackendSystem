package com.lovo.backend.service;

import com.lovo.backend.entity.BackProductEntity;

/**
 * 退货商品业务接口
 */
public interface IBackProductService {
    /**
     * 添加退货商品
     * @param backProductEntity 退货商品对象
     */
   public void add(BackProductEntity backProductEntity);

}
