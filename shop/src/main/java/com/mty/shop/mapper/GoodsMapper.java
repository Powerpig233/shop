package com.mty.shop.mapper;


import com.mty.shop.model.Goods;
import com.mty.shop.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO layer interface
 */
public interface GoodsMapper extends MyMapper<Goods> {

    /**
     * Query list based on parameters
     */
    List<Goods> selectByCondition(Goods goods);

    /**
     * query all
     */
    List<Goods> findAll();

    /**
     * Add information by id
     */
    int addByCondition(Goods goods);

    /**
     * Update information based on id
     */
    int updateById(Goods goods);

    /**
     * According to deletion information
     */
    int deleteById(@Param("id") Integer id);

    /**
     * Query by ID
     */
    Goods selectById(String id);

    /**
     * Query list based on parameters
     */
    List<Goods> queryFilter(Map mp);

}
