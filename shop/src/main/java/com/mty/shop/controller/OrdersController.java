package com.mty.shop.controller;

import com.mty.shop.model.Orders;
import com.mty.shop.service.OrdersService;
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
@RequestMapping(value = "/orders")
public class OrdersController {


    // dependency injection
    @Autowired
    private OrdersService ordersService;


    /**go to list page*/
    @GetMapping("/orders")
    public String userIframe(){
        return "OrdersList";
    }

    /**list data*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findOrders(Orders orders, Integer limit, Integer page, HttpSession session){
        String type = (String)session.getAttribute("type");
        PageHelper.startPage(page,limit);
        List<Orders> ordersList = ordersService.selectByCondition(orders);
        PageInfo<Orders> pages = new PageInfo<>(ordersList);
        return JsonData.table(ordersList,pages.getTotal());
    }


    /**edit details*/
    @GetMapping("/edit")
    @ResponseBody
    public Orders edit(Model model, String id){
        return ordersService.selectById(id);
    }


    /**edit*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(Orders orders){
        int a = ordersService.updateById(orders);
        if (a > 0) {
          return JsonData.success(null,"edit successful! ");
        } else {
          return JsonData.fail("edit fail! ");
        }
    }


    /**Ship*/
    @PostMapping("/updateStatus")
    @ResponseBody
    public JsonData updateStatus(String id,String status){
        try{
            Orders orders = new Orders();
            orders.setId(Integer.parseInt(id));
            orders.setStatus(status);
            ordersService.updateById(orders);
        }catch(Exception ex){
            JsonData.fail("ERRORS");
        }
        return JsonData.success(null,"Shipped successfully! ");
    }


    /**delete*/
    @PostMapping("/del")
    @ResponseBody
    public JsonData del(String id){
        try{
          ordersService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("ERRORS");
        }
        return JsonData.success(null,"delete successful! ");
    }

    /**new add*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(Orders orders){
        Date date = new Date();
        orders.setCreateTime(date);
        int num = ordersService.addByCondition(orders);
        if(num > 0){
          return JsonData.success(null,"add successful! ");
        }else {
          return JsonData.fail("add fail! ");
        }
    }

}
