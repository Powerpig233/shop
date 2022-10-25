package com.mty.shop.controller;

import com.mty.shop.model.Category;
import com.mty.shop.service.CategoryService;
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
@RequestMapping(value = "/category")
public class CategoryController {


    // dependency injection
    @Autowired
    private CategoryService categoryService;


    /**go to the list page*/
    @GetMapping("/category")
    public String userIframe(){
        return "CategoryList";
    }

    /**list data*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findCategory(Category category, Integer limit, Integer page){
        PageHelper.startPage(page,limit);
        List<Category> categoryList = categoryService.selectByCondition(category);
        PageInfo<Category> pages = new PageInfo<>(categoryList);
        return JsonData.table(categoryList,pages.getTotal());
    }


    /**edit details*/
    @GetMapping("/edit")
    @ResponseBody
    public Category edit(Model model, String id){
        return categoryService.selectById(id);
    }


    /**edit*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(Category category){
        int a = categoryService.updateById(category);
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
          categoryService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("ERRORS");
        }
        return JsonData.success(null,"delete successful! ");
    }

    /**new add*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(Category category){
        Date date = new Date();
        category.setCreateTime(date);
        int num = categoryService.addByCondition(category);
        if(num > 0){
          return JsonData.success(null,"add successful! ");
        }else {
          return JsonData.fail("add fail! ");
        }
    }

}
