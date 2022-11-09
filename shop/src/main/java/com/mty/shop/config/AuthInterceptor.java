package com.mty.shop.config;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description: interceptor
 **/
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("userInfo") != null){
            return true;
        }
        // 不符合条件的给出提示信息，并转发到主页面
        request.setAttribute("msg", "You are not logged in, please log in first!");
        request.getRequestDispatcher("/logout").forward(request, response);
        //返回true通过，返回false拦截
        return false;
    }
}
