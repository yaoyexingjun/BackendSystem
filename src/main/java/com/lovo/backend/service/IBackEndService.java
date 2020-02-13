package com.lovo.backend.service;
/**
 * 后端退货业务层接口
 *
 */

import com.lovo.backend.entity.BackEndEntity;

import java.util.List;

public interface IBackEndService {
    /**
     * 添加后端退货记录
     * @param backEndEntity
     */
    public void add(BackEndEntity backEndEntity);

    /**
     * 查询所有后端退货记录
     * @return
     */
    public List<BackEndEntity>findAll();
    /**
     * 通过退货订单编号修改物流状态
     * @param salesOrder  退货订单编号
     * @param tag 状态
     */
    public void updateTagbysalesOrder(String salesOrder,String tag);
}
