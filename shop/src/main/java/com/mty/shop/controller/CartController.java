package com.mty.shop.controller;

import com.mty.shop.model.Cart;
import com.mty.shop.model.User;
import com.mty.shop.service.CartService;
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
@RequestMapping(value = "/cart")
public class CartController {


    // dependency injection
    @Autowired
    private CartService cartService;


    /**go to the list page*/
    @GetMapping("/cart")
    public String userIframe(){
        return "CartList";
    }

    /**list data*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo findCart(Cart cart, Integer limit, Integer page){
        PageHelper.startPage(page,limit);
        List<Cart> cartList = cartService.selectByCondition(cart);
        PageInfo<Cart> pages = new PageInfo<>(cartList);
        return JsonData.table(cartList,pages.getTotal());
    }


    /**edit details*/
    @GetMapping("/edit")
    @ResponseBody
    public Cart edit(Model model, String id){
        return cartService.selectById(id);
    }


    /**edit*/
    @PostMapping("/edit")
    @ResponseBody
    public JsonData edit(Cart cart){
        int a = cartService.updateById(cart);
        if (a > 0) {
          return JsonData.success(null,"edit successful！");
        } else {
          return JsonData.fail("edit fail! ");
        }
    }

    /**Foreground delete delete*/
    @GetMapping("/delete")
    public String delete(String id){
        cartService.deleteById(Integer.parseInt(id));
        return "redirect:/index/cart";
    }


    /**delete*/
    @PostMapping("/del")
    @ResponseBody
    public JsonData del(String id){
        try{
          cartService.deleteById(Integer.parseInt(id));
        }catch(Exception ex){
          JsonData.fail("ERRORS");
        }
        return JsonData.success(null,"delete successful! ");
    }

    /**new add*/
    @PostMapping("/add")
    @ResponseBody
    public JsonData add(Cart cart, HttpSession session){
        Date date = new Date();
        cart.setCreateTime(date);
        String type = (String)session.getAttribute("type");
        if(type.equals("02")){
            User user = (User)session.getAttribute("userInfo");
            if(user!=null){
                cart.setUid(String.valueOf(user.getId()));
            }
        }
        //If the same product continues to be added to the shopping cart, add the quantity
        Cart cart1 = new Cart();
        cart1.setGid(cart.getGid());
        cart1.setUid(cart.getUid());
        List<Cart> carts = cartService.selectByCondition(cart1);
        if(carts.size()==1){
            Cart cart2 = carts.get(0);
            cart2.setNum(String.valueOf(Integer.parseInt(cart2.getNum())+Integer.parseInt(cart.getNum())));
            cartService.updateById(cart2);
            return JsonData.success(null,"Add to Cart successful");
        }
        int num = cartService.addByCondition(cart);
        if(num > 0){
          return JsonData.success(null,"Add to Cart successful");
        }else {
          return JsonData.fail("Failed to add to cart");
        }
    }

}
