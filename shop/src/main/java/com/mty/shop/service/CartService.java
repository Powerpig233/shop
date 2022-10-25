package com.mty.shop.service;

import com.mty.shop.mapper.CartMapper;
import com.mty.shop.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 * Service interface implementation class
 */
@Service
@Transactional
public class CartService {

    @Autowired
    private CartMapper cartMapper;


    /**
     * query all
     */
    public List<Cart> findAll(){
        return cartMapper.findAll();
    }

    /**
     * Query list based on parameters
     */
    public List<Cart> selectByCondition(Cart cart) {
        return cartMapper.selectByCondition(cart);
    }

    /**
     * Query list based on parameters
     */
    public List<Cart> queryFilter(Map mp) {
        return cartMapper.queryFilter(mp);
    }

    /**
     * Update information based on id
     */
    public int updateById(Cart cart)  {
        return cartMapper.updateById(cart);
    }


    /**
     * Query information by id
     */
    public Cart selectById(String id) {
        return cartMapper.selectById(id);
    }


    /**
     * delete by id
     */
    public void deleteById(Integer id){
        cartMapper.deleteById(id);
    }

    /**
     * delete by id
     */
    public void deleteByUid(Integer id){
        cartMapper.deleteByUid(id);
    }

    /**
     * increase
     */
    public int addByCondition(Cart cart) {
        int a = cartMapper.addByCondition(cart);
        return a;
    }



}
