package com.redbyte.wigen.droolsdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.redbyte.wigen.droolsdemo.core.dao")
@SpringBootApplication
public class DroolsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DroolsDemoApplication.class, args);
    }

}
