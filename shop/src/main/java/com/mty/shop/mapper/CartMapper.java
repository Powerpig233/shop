package com.mty.shop.mapper;


import com.mty.shop.model.Cart;
import com.mty.shop.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO layer interface
 */
public interface CartMapper extends MyMapper<Cart> {

    /**
     * Query list based on parameters
     */
    List<Cart> selectByCondition(Cart cart);

    /**
     * query all
     */
    List<Cart> findAll();

    /**
     * Add information by id
     */
    int addByCondition(Cart cart);

    /**
     * Update information based on id
     */
    int updateById(Cart cart);

    /**
     * According to deletion information
     */
    int deleteById(@Param("id") Integer id);

    int deleteByUid(@Param("id") Integer id);

    /**
     * Query by ID
     */
    Cart selectById(String id);

    /**
     * Query list based on parameters
     */
    List<Cart> queryFilter(Map mp);

}
