package com.mty.shop.service;

import com.mty.shop.mapper.OrderItemMapper;
import com.mty.shop.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 * Service interface implementation class
 */
@Service
@Transactional
public class OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;


    /**
     * query all
     */
    public List<OrderItem> findAll(){
        return orderItemMapper.findAll();
    }

    /**
     * Query list based on parameters
     */
    public List<OrderItem> selectByCondition(OrderItem orderItem) {
        return orderItemMapper.selectByCondition(orderItem);
    }

    /**
     * Query list based on parameters
     */
    public List<OrderItem> queryFilter(Map mp) {
        return orderItemMapper.queryFilter(mp);
    }

    /**
     * Update information based on id
     */
    public int updateById(OrderItem orderItem)  {
        return orderItemMapper.updateById(orderItem);
    }


    /**
     * Query information by id
     */
    public OrderItem selectById(String id) {
        return orderItemMapper.selectById(id);
    }


    /**
     * delete by id
     */
    public void deleteById(Integer id){
        orderItemMapper.deleteById(id);
    }

    /**
     * increase
     */
    public int addByCondition(OrderItem orderItem) {
        int a = orderItemMapper.addByCondition(orderItem);
        return a;
    }



}
