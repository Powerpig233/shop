package com.mty.shop.controller;

import com.mty.shop.model.Category;
import com.mty.shop.model.Goods;
import com.mty.shop.service.CategoryService;
import com.mty.shop.service.GoodsService;
import com.mty.shop.util.JsonData;
import com.mty.shop.util.PageResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @description: control layer
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {


    // dependency injection
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CategoryService categoryService;

    /**go to list page*/
    @GetMapping("/goods")
    public String userIframe(Model model, HttpSession session){
        Category category = new Category();
        List<Category> categories = categoryService.selectByCondition(category);
        model.addAttribute("categories",categories);
        return "GoodsList";
    }

    /**list data*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findGoods(Goods goods, Integer limit, Integer page, HttpSession session){
        PageHelper.startPage(page,limit);
        List<Goods> goodsList = goodsService.selectByCondition(goods);
        PageInfo<Goods> pages = new PageInfo<>(goodsList);
        return JsonData.table(goodsList,pages.getTotal());
    }


    /**edit details*/
    @GetMapping("/edit")
    @ResponseBody
    public Goods edit(Model model, String id){
        return goodsService.selectById(id);
    }


    /**edit*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(Goods goods){
        int a = goodsService.updateById(goods);
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
          goodsService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("ERRORS");
        }
        return JsonData.success(null,"delete successful! ");
    }

    /**new add*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(Goods goods, HttpSession session){
        Date date = new Date();
        goods.setCreateTime(date);
        int num = goodsService.addByCondition(goods);
        if(num > 0){
          return JsonData.success(null,"add successful! ");
        }else {
          return JsonData.fail("add fail! ");
        }
    }

}
