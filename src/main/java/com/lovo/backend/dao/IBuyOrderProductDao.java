package com.lovo.backend.dao;

import com.lovo.backend.entity.BuyOrderProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 采购订单商品持久层接口
 */
public interface IBuyOrderProductDao extends CrudRepository<BuyOrderProductEntity,Long> {
    /**
     * 查询全部采购订单商品
     * @return 采购订单商品集合
     */
    @Query("from BuyOrderProductEntity bope order by bope.buyCode desc")
    public List<BuyOrderProductEntity> findAllBuyOrderProduct();
}
