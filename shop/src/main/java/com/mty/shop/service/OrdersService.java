package com.mty.shop.service;

import com.mty.shop.mapper.OrdersMapper;
import com.mty.shop.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 * Service interface implementation class
 */
@Service
@Transactional
public class OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;


    /**
     * query all
     */
    public List<Orders> findAll(){
        return ordersMapper.findAll();
    }

    /**
     * Query list based on parameters
     */
    public List<Orders> selectByCondition(Orders orders) {
        return ordersMapper.selectByCondition(orders);
    }

    /**
     * Query list based on parameters
     */
    public List<Orders> queryFilter(Map mp) {
        return ordersMapper.queryFilter(mp);
    }

    /**
     * Update information based on id
     */
    public int updateById(Orders orders)  {
        return ordersMapper.updateById(orders);
    }


    /**
     * Query information by id
     */
    public Orders selectById(String id) {
        return ordersMapper.selectById(id);
    }


    /**
     * delete by id
     */
    public void deleteById(Integer id){
        ordersMapper.deleteById(id);
    }

    /**
     * increase
     */
    public int addByCondition(Orders orders) {
        int a = ordersMapper.addByCondition(orders);
        return a;
    }



}
