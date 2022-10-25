package com.mty.shop.service;

import com.mty.shop.mapper.CategoryMapper;
import com.mty.shop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 * Service interface implementation class
 */
@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    /**
     * query all
     */
    public List<Category> findAll(){
        return categoryMapper.findAll();
    }

    /**
     * Query list based on parameters
     */
    public List<Category> selectByCondition(Category category) {
        return categoryMapper.selectByCondition(category);
    }

    /**
     * Query list based on parameters
     */
    public List<Category> queryFilter(Map mp) {
        return categoryMapper.queryFilter(mp);
    }

    /**
     * Update information based on id
     */
    public int updateById(Category category)  {
        return categoryMapper.updateById(category);
    }


    /**
     * Query information by id
     */
    public Category selectById(String id) {
        return categoryMapper.selectById(id);
    }


    /**
     * delete by id
     */
    public void deleteById(Integer id){
        categoryMapper.deleteById(id);
    }

    /**
     * increase
     */
    public int addByCondition(Category category) {
        int a = categoryMapper.addByCondition(category);
        return a;
    }



}
