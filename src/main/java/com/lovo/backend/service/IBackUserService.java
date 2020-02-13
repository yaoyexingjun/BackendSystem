package com.lovo.backend.service;

import com.lovo.backend.entity.BackUserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 用户退货业务接口
 */
public interface IBackUserService {
    /**
     * 保存用户退货信息
     * @param backUserEntity 用户退货对象
     */
    public void add(BackUserEntity backUserEntity);

    /**
     * 查询所有用户退货记录
     * @return 用户退货记录集合
     */
    public List<BackUserEntity> findAll();
    /**
     * 通过订单编号修改订单物流状态
     * @param orderNum
     * @param tag
     */
    public void update(String orderNum,String tag);
}
