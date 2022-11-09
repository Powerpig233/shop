package com.mty.shop.controller;

import com.mty.shop.model.Admin;
import com.mty.shop.service.AdminService;
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
@RequestMapping(value = "/admin")
public class AdminController {


    // dependency injection
    @Autowired
    private AdminService adminService;


    /**go to the list page*/
    @GetMapping("/admin")
    public String userIframe(){
        return "AdminList";
    }

    /**list data*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findAdmin(Admin admin, Integer limit, Integer page){
        PageHelper.startPage(page,limit);
        List<Admin> adminList = adminService.selectByCondition(admin);
        PageInfo<Admin> pages = new PageInfo<>(adminList);
        return JsonData.table(adminList,pages.getTotal());
    }


    /**Edit details*/
    @GetMapping("/edit")
    @ResponseBody
    public Admin edit(Model model, String id){
        return adminService.selectById(id);
    }


    /**edit*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(Admin admin){
        int a = adminService.updateById(admin);
        if (a > 0) {
          return JsonData.success(null,"edit successful！");
        } else {
          return JsonData.fail("edit fail! ");
        }
    }


    /**delete*/
    @PostMapping("/del")
    @ResponseBody
    public JsonData del(String id){
        try{
          adminService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("ERRORS");
        }
        return JsonData.success(null,"delete successful! ");
    }

    /**new add*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(Admin admin){
        Date date = new Date();
        admin.setCreateTime(date);
        int num = adminService.addByCondition(admin);
        if(num > 0){
          return JsonData.success(null,"add successful! ");
        }else {
          return JsonData.fail("add fail!");
        }
    }

}
