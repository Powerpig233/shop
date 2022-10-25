package com.mty.shop.mapper;


import com.mty.shop.model.Orders;
import com.mty.shop.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO layer interface
 */
public interface OrdersMapper extends MyMapper<Orders> {

    /**
     * Query list based on parameters
     */
    List<Orders> selectByCondition(Orders orders);

    /**
     * query all
     */
    List<Orders> findAll();

    /**
     * Add information by id
     */
    int addByCondition(Orders orders);

    /**
     * Update information based on id
     */
    int updateById(Orders orders);

    /**
     * According to deletion information
     */
    int deleteById(@Param("id") Integer id);

    /**
     * Query by ID
     */
    Orders selectById(String id);

    /**
     * Query list based on parameters
     */
    List<Orders> queryFilter(Map mp);

}
