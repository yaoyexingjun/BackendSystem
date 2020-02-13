package com.lovo.backend.dao;

import com.lovo.backend.entity.BackProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * 退货商品持久类接口
 */
public interface IBackProductDao extends CrudRepository<BackProductEntity,Integer> {
    /**
     * 通过商品编号查询商品
     * @param productCode 商品编号
     * @return 商品集合
     */
  public List<BackProductEntity> findAllByProductCode(String productCode);

}
