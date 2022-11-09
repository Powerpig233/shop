package com.mty.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: register interceptor
 **/
//register interceptor
@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        //Register your own interceptor and set the intercepted request path
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**")//Intercepted access paths, intercepting all
                .excludePathPatterns("/static/**","/","/login","/logout","/register","/upload/*","/front/*");//Excluded request paths, excluded static resource paths
    }
}
