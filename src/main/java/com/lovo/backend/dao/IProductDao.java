package com.lovo.backend.dao;


import com.lovo.backend.entity.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 上下架Dao层接口
 */
public interface IProductDao extends CrudRepository<ProductEntity,Long>,JpaSpecificationExecutor{
    /**
     * 查询前端所有产品,按未上架先排序
     * @param page 分页参数
     * @return 返回商品集合
     */
    @Query("from ProductEntity where price >0 order by onStatus asc")
    public List<ProductEntity> findAll( Pageable page);

    /**
     * 查询前端商品,按上下架和商品类型条件查询
     * @param onStatus 上下架状态
     * @param type 商品类型
     * @param page 分页查询
     * @return
     */
    @Query("from ProductEntity where price >0 and onStatus=?1 and productType like %?2% ")
    public List<ProductEntity> findByState(int onStatus ,String type,Pageable page);


}
