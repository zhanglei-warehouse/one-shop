package com.one.shop.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: one-shop
 * @author: Zhang Lei
 * @create: 2020-05-18 19:34
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaCenterApplication.class,args);
    }
}
