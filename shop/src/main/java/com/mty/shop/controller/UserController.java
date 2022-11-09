package com.mty.shop.controller;

import com.mty.shop.model.User;
import com.mty.shop.service.UserService;
import com.mty.shop.util.JsonData;
import com.mty.shop.util.PageResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * @description: control layer
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {


    // dependency injection
    @Autowired
    private UserService userService;


    /**go to list page*/
    @GetMapping("/user")
    public String userIframe(){
        return "UserList";
    }

    /**list data*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findUser(User user, Integer limit, Integer page){
        PageHelper.startPage(page,limit);
        List<User> userList = userService.selectByCondition(user);
        PageInfo<User> pages = new PageInfo<>(userList);
        return JsonData.table(userList,pages.getTotal());
    }


    /**edit details*/
    @GetMapping("/edit")
    @ResponseBody
    public User edit(Model model, String id){
        return userService.selectById(id);
    }


    /**edit*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(User user){
        int a = userService.updateById(user);
        if (a > 0) {
          return JsonData.success(null,"edit successful! ");
        } else {
          return JsonData.fail("edit fail! ");
        }
    }


    /**delete*/
    @PostMapping("/del")
    @ResponseBody
    public JsonData del(String id){
        try{
          userService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("ERRORS");
        }
        return JsonData.success(null,"delete successful! ");
    }

    /**new add*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(User user){
        Date date = new Date();
        user.setCreateTime(date);
        int num = userService.addByCondition(user);
        if(num > 0){
          return JsonData.success(null,"add successful! ");
        }else {
          return JsonData.fail("add fail! ");
        }
    }

}
