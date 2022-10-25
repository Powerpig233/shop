package com.mty.shop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mty.shop.model.Category;
import com.mty.shop.model.Goods;
import com.mty.shop.service.CategoryService;
import com.mty.shop.service.GoodsService;
import com.mty.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/front")
public class FrontController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;


    //front page home page
    @GetMapping("/")
    public String userIframe(Model model){
        Map mp = new HashMap<>();
        mp.put("limit","1");
        mp.put("status","02");
        List<Goods> goods = goodsService.queryFilter(mp);
        model.addAttribute("goods",goods);
        return "show";
    }


    //goods
    @GetMapping("/good")
    public String good(Model model,String searchName,String cid, Integer pageNum, Integer pageSize){
        Map mp = new HashMap<>();
        mp.put("name",searchName);
        mp.put("cid",cid);
        if(pageNum==null){
            pageNum =1;
        }
        if(pageSize==null){
            pageSize =8;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> goodsList = goodsService.queryFilter(mp);
        PageInfo<Goods> goods = new PageInfo<>(goodsList);
        model.addAttribute("goods",goods);
        Category category = new Category();
        List<Category> categories = categoryService.selectByCondition(category);
        model.addAttribute("categories",categories);
        return "good";
    }

    //goods details
    @GetMapping("/goodDetail")
    public String goodDetail(String id,Model model){
        Goods good = goodsService.selectById(id);
        model.addAttribute("id",id);
        model.addAttribute("good",good);
        return "goodDetail";
    }









}
