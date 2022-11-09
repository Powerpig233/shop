package com.mty.shop.mapper;


import com.mty.shop.model.User;
import com.mty.shop.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO layer interface
 */
public interface UserMapper extends MyMapper<User> {

    /**
     * Query list based on parameters
     */
    List<User> selectByCondition(User user);

    /**
     * query all
     */
    List<User> findAll();

    /**
     * Add information by id
     */
    int addByCondition(User user);

    /**
     * Update information based on id
     */
    int updateById(User user);

    /**
     * According to deletion information
     */
    int deleteById(@Param("id") Integer id);

    /**
     * Query by ID
     */
    User selectById(String id);

    /**
     * Query list based on parameters
     */
    List<User> queryFilter(Map mp);

}
