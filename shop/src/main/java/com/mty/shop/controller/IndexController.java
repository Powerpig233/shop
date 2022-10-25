package com.mty.shop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mty.shop.model.*;
import com.mty.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderItemService orderItemService;

    //cart
    @GetMapping("/cart")
    public String cart(Model model, HttpSession session, Integer pageNum, Integer pageSize){
        if(pageNum==null){
            pageNum =1;
        }
        if(pageSize==null){
            pageSize =5;
        }
        String type = (String)session.getAttribute("type");
        if(type.equals("02")){
            User user = (User)session.getAttribute("userInfo");
            if(user!=null){
                Map mp = new HashMap();
                mp.put("uid",user.getId());
                PageHelper.startPage(pageNum,pageSize);
                List<Cart> cartList = cartService.queryFilter(mp);
                PageInfo<Cart> carts = new PageInfo<>(cartList);
                for(int i=0;i<carts.getList().size();i++){
                    if(carts.getList().get(i).getGid()!=null){
                        Goods goods = goodsService.selectById(carts.getList().get(i).getGid());
                        int total = Integer.parseInt(goods.getMoney())*Integer.parseInt(carts.getList().get(i).getNum());
                        carts.getList().get(i).setTotal(String.valueOf(total));
                        carts.getList().get(i).setGoods(goods);
                    }
                }
                model.addAttribute("carts",carts);
            }
        }
        return "cart";
    }



    //order
    @GetMapping("/submitOrder")
    public String submitOrder(Model model, HttpSession session){
        String type = (String)session.getAttribute("type");
        if(type.equals("02")){
            User user = (User)session.getAttribute("userInfo");
            if(user!=null){
                Map mp = new HashMap();
                mp.put("uid",user.getId());
                List<Cart> cartList = cartService.queryFilter(mp);
                for(int i=0;i<cartList.size();i++){
                    if(cartList.get(i).getGid()!=null){
                        Goods goods = goodsService.selectById(cartList.get(i).getGid());
                        int total = Integer.parseInt(goods.getMoney())*Integer.parseInt(cartList.get(i).getNum());
                        cartList.get(i).setTotal(String.valueOf(total));
                        cartList.get(i).setGoods(goods);
                    }
                }
                int num_total = 0;
                int money_total = 0;
                Orders order = new Orders();
                SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
                String orderNum = sf.format(new Date());
                order.setNo(orderNum);
                order.setStatus("01");
                order.setUid(String.valueOf(user.getId()));
                Date date = new Date();
                order.setCreateTime(date);
                int nn = ordersService.addByCondition(order);
                int orderId = order.getId();
                //line item addition
                for(int i=0;i<cartList.size();i++){
                    OrderItem orderItem = new OrderItem();
                    orderItem.setGid(cartList.get(i).getGid());
                    orderItem.setOid(String.valueOf(orderId));
                    orderItem.setMoney(cartList.get(i).getGoods().getMoney());
                    orderItem.setNum(cartList.get(i).getNum());
                    orderItem.setCreateTime(date);
                    orderItemService.addByCondition(orderItem);
                    num_total = num_total+Integer.parseInt(cartList.get(i).getNum());
                    money_total = money_total + Integer.parseInt(cartList.get(i).getNum())*Integer.parseInt(cartList.get(i).getGoods().getMoney());
                }
                //Update order information
                Orders orders = ordersService.selectById(String.valueOf(orderId));
                orders.setNum(String.valueOf(num_total));
                orders.setTotal(String.valueOf(money_total));
                ordersService.updateById(orders);
                //empty cart
                cartService.deleteByUid(user.getId());
            }
        }
        return "redirect:/index/myOrder";
    }



    //My Order
    @GetMapping("/myOrder")
    public String myorder(Model model, HttpSession session, Integer pageNum, Integer pageSize){
        if(pageNum==null){
            pageNum =1;
        }
        if(pageSize==null){
            pageSize =5;
        }
        String type = (String)session.getAttribute("type");
        if(type.equals("02")){
            User user = (User)session.getAttribute("userInfo");
            if(user!=null){
                Map mp = new HashMap();
                mp.put("uid",user.getId());
                PageHelper.startPage(pageNum,pageSize);
                List<Orders> ordersList = ordersService.queryFilter(mp);
                PageInfo<Orders> orders = new PageInfo<>(ordersList);
                model.addAttribute("orders",orders);
            }
        }
        return "myOrder";
    }


    //My Order
    @GetMapping("/myOrderDetail")
    @ResponseBody
    public Map myorder(String id){
        Orders orders = ordersService.selectById(id);
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(String.valueOf(orders.getId()));
        List<OrderItem> orderItems = orderItemService.selectByCondition(orderItem);
        Map mp = new HashMap();
        mp.put("state",0);
        mp.put("data",orderItems);
        return mp;
    }


    //cancel order
    @GetMapping("/quxiaoOrder")
    @ResponseBody
    public Map quxiaoOrder(String id){
        Orders orders = ordersService.selectById(id);
        orders.setStatus("02");
        ordersService.updateById(orders);
        Map mp = new HashMap();
        mp.put("message","Cancel order successful! ");
        return mp;
    }

    //my info
    @GetMapping("/myInfo")
    public String myInfo(){
        return "myInfo";
    }

    //my info
    @GetMapping("/myInfoSubmit")
    public String myInfo(HttpSession session,User user,Model model){
        if(user.getPhone()==null || user.getPhone().equals("")){
            model.addAttribute("msg","Please fill in your phone number! ");
            return "myInfo";
        }
        if(user.getRealname()==null || user.getRealname().equals("")){
            model.addAttribute("msg","Please fill in your name！");
            return "myInfo";
        }
        String type = (String)session.getAttribute("type");
        if(type.equals("02")){
            User usersession = (User)session.getAttribute("userInfo");
            if(!user.getPassword().equals(usersession.getPassword())){
                model.addAttribute("msg","The original password was entered incorrectly, please re-enter!");
                return "myInfo";
            }
        }
        List<User> all = userService.findAll();
        for(int i=0;i<all.size();i++){
            if(!all.get(i).getId().equals(user.getId()) && all.get(i).getPhone().equals(user.getPhone())){
                model.addAttribute("msg","The phone number is duplicated, please try again!");
                return "myInfo";
            }
        }
        if(user.getPasswords()!=null && !user.getPasswords().equals("")){
            user.setPassword(user.getPasswords());
        }
        userService.updateById(user);
        session.removeAttribute("userInfo");
        session.setAttribute("userInfo",user);
        model.addAttribute("msg","Successfully modified!");
        return "myInfo";
    }





}
