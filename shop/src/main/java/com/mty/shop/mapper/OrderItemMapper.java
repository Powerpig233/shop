package com.mty.shop.mapper;


import com.mty.shop.model.OrderItem;
import com.mty.shop.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO layer interface
 */
public interface OrderItemMapper extends MyMapper<OrderItem> {

    /**
     * Query list based on parameters
     */
    List<OrderItem> selectByCondition(OrderItem orderItem);

    /**
     * query all
     */
    List<OrderItem> findAll();

    /**
     * Add information by id
     */
    int addByCondition(OrderItem orderItem);

    /**
     * Update information based on id
     */
    int updateById(OrderItem orderItem);

    /**
     * According to deletion information
     */
    int deleteById(@Param("id") Integer id);

    /**
     * Query by ID
     */
    OrderItem selectById(String id);

    /**
     * Query list based on parameters
     */
    List<OrderItem> queryFilter(Map mp);

}
