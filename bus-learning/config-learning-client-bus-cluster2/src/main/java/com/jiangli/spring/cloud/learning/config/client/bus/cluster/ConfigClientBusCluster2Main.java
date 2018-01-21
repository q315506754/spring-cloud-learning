package com.jiangli.spring.cloud.learning.config.client.bus.cluster;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@RestController
@RefreshScope
public class ConfigClientBusCluster2Main {

    @Value("${auth.username}")
    String name = "World";

    @Value("${jdbcUrl}")
    String jdbcUrl;

    @Value("${jmsUrl}")
    String jmsUrl ;


    public static void main(String[] args) {
        SpringApplication.run(ConfigClientBusCluster2Main.class, args);
    }

    /**
     * http://localhost:8815/
     * @return
     */
    @RequestMapping("/")
    public String home() {
        System.out.println(jdbcUrl);
        System.out.println(jmsUrl);
        System.out.println(name);
        return "ConfigClientBusCluster1Main Hello " + name;
    }

}