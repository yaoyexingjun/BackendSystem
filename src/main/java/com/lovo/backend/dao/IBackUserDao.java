package com.lovo.backend.dao;
/**
 * 用户退货持久接口
 *
 */

import com.lovo.backend.entity.BackUserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBackUserDao extends CrudRepository<BackUserEntity,Integer> {
    /**
     * 通过订单编号修改订单物流状态
     * @param orderNum
     * @param tag
     */
    @Query("update BackUserEntity set tag=?2 where orderNum=?1 ")
    @Modifying
    public void update(String orderNum,String tag);

    /**
     * 查询所有用户退货订单 按时间的降序排序
     * @return
     */
    @Query("from BackUserEntity  order by backTime desc")
    public List<BackUserEntity> findAll();
}
