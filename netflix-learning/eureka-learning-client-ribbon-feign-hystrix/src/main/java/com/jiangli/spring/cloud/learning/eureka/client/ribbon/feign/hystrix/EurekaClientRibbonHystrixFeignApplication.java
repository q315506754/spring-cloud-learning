package com.jiangli.spring.cloud.learning.eureka.client.ribbon.feign.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.HystrixStreamEndpoint;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
public class EurekaClientRibbonHystrixFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientRibbonHystrixFeignApplication.class, args);
    }

    // 不知道怎么配置 主动注册一个才能访问到
    // http://localhost:8767/hystrix.stream
    @Bean
    public HystrixStreamEndpoint func() {
        return new HystrixStreamEndpoint();
    }

}