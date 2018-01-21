package com.jiangli.spring.cloud.learning.eureka.client.ribbon.feign.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
public class EurekaClientRibbonHystrixFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientRibbonHystrixFeignApplication.class, args);
    }

}