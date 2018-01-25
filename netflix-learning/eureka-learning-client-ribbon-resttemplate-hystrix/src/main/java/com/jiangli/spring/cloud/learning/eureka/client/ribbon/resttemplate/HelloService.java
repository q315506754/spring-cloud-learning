package com.jiangli.spring.cloud.learning.eureka.client.ribbon.resttemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;
    private long lastTs=System.currentTimeMillis();
    private long c=0;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        System.out.println("执行远程.."+(System.currentTimeMillis() - lastTs)+" ms");
        System.out.println("失败次数:"+c);

        lastTs = System.currentTimeMillis();
        return restTemplate.getForObject("http://eureka-learning-client/hi?name="+name,String.class);
    }

    public String hiError(String name) {
        c++;
        System.out.println("invoke error:"+c);
        return "hi,"+name+",sorry,error!";
    }
}