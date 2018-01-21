package com.jiangli.spring.cloud.learning.eureka.client.ribbon.feign.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    MyFeignService schedualServiceHi;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        System.out.println("HiController invoke ");
         return "eureka-learning-client-ribbon-feign-hystrix:"+schedualServiceHi.sayHiFromClientOne(name);
    }
}