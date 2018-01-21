package com.jiangli.spring.cloud.learning.eureka.client.ribbon.feign.hystrix;

import org.springframework.stereotype.Component;

/**
 * @author Jiangli
 * @date 2018/1/21 17:10
 */
@Component
public class MyFeignServiceFallBack implements  MyFeignService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
