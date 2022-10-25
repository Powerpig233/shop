package com.mty.shop.controller;

import com.mty.shop.model.OrderItem;
import com.mty.shop.service.OrderItemService;
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
@RequestMapping(value = "/orderItem")
public class OrderItemController {


    // dependency injection
    @Autowired
    private OrderItemService orderItemService;


    /**go to list page*/
    @GetMapping("/orderItem")
    public String userIframe(){
        return "OrderItemList";
    }

    /**list data*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findOrderItem(OrderItem orderItem, Integer limit, Integer page, HttpSession session){
        PageHelper.startPage(page,limit);
        List<OrderItem> orderItemList = orderItemService.selectByCondition(orderItem);
        PageInfo<OrderItem> pages = new PageInfo<>(orderItemList);
        return JsonData.table(orderItemList,pages.getTotal());
    }


    /**edit details*/
    @GetMapping("/edit")
    @ResponseBody
    public OrderItem edit(Model model, String id){
        return orderItemService.selectById(id);
    }


    /**edit*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(OrderItem orderItem){
        int a = orderItemService.updateById(orderItem);
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
          orderItemService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("ERRORS");
        }
        return JsonData.success(null,"delete successful! ");
    }

    /**new add*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(OrderItem orderItem){
        Date date = new Date();
        orderItem.setCreateTime(date);
        int num = orderItemService.addByCondition(orderItem);
        if(num > 0){
          return JsonData.success(null,"add successful! ");
        }else {
          return JsonData.fail("add fail! ");
        }
    }

}
