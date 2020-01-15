package com.lovo.backend.dao;


import com.lovo.backend.entity.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

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
     * 查询前端产品总条数
     * @return
     */
    @Query("select count(productId) from ProductEntity where price >0 ")
    public int findAllCount();
    /**
     * 查询前端商品,按上下架和商品类型条件查询
     * @param onStatus 上下架状态
     * @param type 商品类型
     * @param page 分页查询
     * @return
     */
    @Query("from ProductEntity where price >0 and onStatus=?1 and productType like %?2% ")
    public List<ProductEntity> findByState(int onStatus ,String type,Pageable page);


    /**
     * 根据上下架状态和产品类型查询总条数
     * @param onStatus
     * @param type
     * @return
     */
    @Query("select count(productId) from ProductEntity where price >0 and onStatus=?1 and productType like %?2% ")
    public int findByStateCount(int onStatus ,String type);

    /**
     * 根据商品编号修改商品上下架状态
     * @param state 上下架状态 0未上架 1上架 2下架
     * @param productCode 产品编号
     */
    @Query("update ProductEntity set onStatus=?1 where productCode=?2")
    @Modifying
    public void updateState(int state,String productCode);
}
