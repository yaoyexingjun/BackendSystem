package com.lovo.backend.dao;

import com.lovo.backend.entity.BackEndEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 后端退货持久接口
 *
 */
public interface IBackEndDao extends CrudRepository<BackEndEntity,Integer> {
    /**
     * 通过退货订单编号修改物流状态
     * @param salesOrder  退货订单编号
     * @param tag 状态
     */
    @Query("update BackEndEntity set tag=?2 where salesOrder=?1 ")
    @Modifying
    public void updateTagbysalesOrder(String salesOrder,String tag);

    /**
     * 查询出所有后端退货
     * @return 后端退货集合
     */
    @Query("from BackEndEntity  order by backTime desc")
    public List<BackEndEntity> findAll();
}
