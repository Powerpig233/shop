package com.mty.shop.mapper;


import com.mty.shop.model.Admin;
import com.mty.shop.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO layer interface
 */
public interface AdminMapper extends MyMapper<Admin> {

    /**
     * Query list based on parameters
     */
    List<Admin> selectByCondition(Admin admin);

    /**
     * query all
     */
    List<Admin> findAll();

    /**
     * Add information by id
     */
    int addByCondition(Admin admin);

    /**
     * Update information based on id
     */
    int updateById(Admin admin);

    /**
     * According to deletion information
     */
    int deleteById(@Param("id") Integer id);

    /**
     * Query by ID
     */
    Admin selectById(String id);

    /**
     * Query list based on parameters
     */
    List<Admin> queryFilter(Map mp);

}
