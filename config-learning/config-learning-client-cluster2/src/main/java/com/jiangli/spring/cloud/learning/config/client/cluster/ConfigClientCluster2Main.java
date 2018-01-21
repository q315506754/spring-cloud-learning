package com.jiangli.spring.cloud.learning.config.client.cluster;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@RestController
public class ConfigClientCluster2Main {

    @Value("${auth.username}")
    String name = "World";

    @Value("${jdbcUrl}")
    String jdbcUrl;

    @Value("${jmsUrl}")
    String jmsUrl ;


    public static void main(String[] args) {
        SpringApplication.run(ConfigClientCluster2Main.class, args);
    }

    /**
     * http://localhost:8812/
     * @return
     */
    @RequestMapping("/")
    public String home() {
        System.out.println(jdbcUrl);
        System.out.println(jmsUrl);
        System.out.println(name);
        return "ClientCluster2Main Hello " + name;
    }

}