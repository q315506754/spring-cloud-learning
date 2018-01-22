package com.jiangli.spring.cloud.learning.sleuth.client.zipkin;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ZipkinClient2Application {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinClient2Application.class, args);
    }
    
    private static final Logger LOG = Logger.getLogger(ZipkinClient2Application.class.getName());
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${spring.application.name}")
    private String client;
    
    @RequestMapping("/b")
    public String callHome(){
        LOG.log(Level.INFO, "calling trace b  ");
//        return "bbbbbbbbbb";
        return restTemplate.getForObject("http://localhost:9423/c", String.class);
    }
    
    @RequestMapping("/f")
    public String info(){
        LOG.log(Level.INFO, "calling trace f ");
        return "ffffffffff";
        
    }
    
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    
    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
}
