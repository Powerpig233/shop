package com.mty.shop.service;

import com.mty.shop.mapper.AdminMapper;
import com.mty.shop.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 * Serviceinterface implementation class
 */
@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;


    /**
     * query all
     */
    public List<Admin> findAll(){
        return adminMapper.findAll();
    }

    /**
     * Query list based on parameters
     */
    public List<Admin> selectByCondition(Admin admin) {
        return adminMapper.selectByCondition(admin);
    }

    /**
     * Query list based on parameters
     */
    public List<Admin> queryFilter(Map mp) {
        return adminMapper.queryFilter(mp);
    }

    /**
     * Update information based on id
     */
    public int updateById(Admin admin)  {
        return adminMapper.updateById(admin);
    }


    /**
     * Query information by id
     */
    public Admin selectById(String id) {
        return adminMapper.selectById(id);
    }


    /**
     * delete by id
     */
    public void deleteById(Integer id){
        adminMapper.deleteById(id);
    }

    /**
     * Increase
     */
    public int addByCondition(Admin admin) {
        int a = adminMapper.addByCondition(admin);
        return a;
    }



}
