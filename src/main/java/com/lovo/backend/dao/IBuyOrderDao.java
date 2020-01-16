package com.lovo.backend.dao;

import com.lovo.backend.entity.BuyOrderEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * 采购订单持久层接口
 */
public interface IBuyOrderDao extends CrudRepository<BuyOrderEntity,Long> {

}
