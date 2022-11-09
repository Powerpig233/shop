package com.mty.shop.service;

import com.mty.shop.mapper.GoodsMapper;
import com.mty.shop.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 * Service interface implementation class
 */
@Service
@Transactional
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    /**
     * query all
     */
    public List<Goods> findAll(){
        return goodsMapper.findAll();
    }

    /**
     * Query list based on parameters
     */
    public List<Goods> selectByCondition(Goods goods) {
        return goodsMapper.selectByCondition(goods);
    }

    /**
     * Query list based on parameters
     */
    public List<Goods> queryFilter(Map mp) {
        return goodsMapper.queryFilter(mp);
    }

    /**
     * Update information based on id
     */
    public int updateById(Goods goods)  {
        return goodsMapper.updateById(goods);
    }


    /**
     * Query information by id
     */
    public Goods selectById(String id) {
        return goodsMapper.selectById(id);
    }


    /**
     * delete by id
     */
    public void deleteById(Integer id){
        goodsMapper.deleteById(id);
    }

    /**
     * increase
     */
    public int addByCondition(Goods goods) {
        int a = goodsMapper.addByCondition(goods);
        return a;
    }



}
