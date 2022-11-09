package com.mty.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

//Configure package scanning for springboot
@SpringBootApplication
@MapperScan("com.mty.shop.mapper")
public class Application {

    /**
     * start method
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
