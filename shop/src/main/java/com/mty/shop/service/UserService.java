package com.mty.shop.service;

import com.mty.shop.mapper.UserMapper;
import com.mty.shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 * Service interface implementation class
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * query all
     */
    public List<User> findAll(){
        return userMapper.findAll();
    }

    /**
     * Query list based on parameters
     */
    public List<User> selectByCondition(User user) {
        return userMapper.selectByCondition(user);
    }

    /**
     * Query list based on parameters
     */
    public List<User> queryFilter(Map mp) {
        return userMapper.queryFilter(mp);
    }

    /**
     * Update information based on id
     */
    public int updateById(User user)  {
        return userMapper.updateById(user);
    }


    /**
     * Query information by id
     */
    public User selectById(String id) {
        return userMapper.selectById(id);
    }


    /**
     * delete by id
     */
    public void deleteById(Integer id){
        userMapper.deleteById(id);
    }

    /**
     * increase
     */
    public int addByCondition(User user) {
        int a = userMapper.addByCondition(user);
        return a;
    }



}
