package com.mty.shop.mapper;


import com.mty.shop.model.Category;
import com.mty.shop.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO layer interface
 */
public interface CategoryMapper extends MyMapper<Category> {

    /**
     * Query list based on parameters
     */
    List<Category> selectByCondition(Category category);

    /**
     * query all
     */
    List<Category> findAll();

    /**
     * Add information by id
     */
    int addByCondition(Category category);

    /**
     * Update information based on id
     */
    int updateById(Category category);

    /**
     * According to deletion information
     */
    int deleteById(@Param("id") Integer id);

    /**
     * Query by ID
     */
    Category selectById(String id);

    /**
     * Query list based on parameters
     */
    List<Category> queryFilter(Map mp);

}
