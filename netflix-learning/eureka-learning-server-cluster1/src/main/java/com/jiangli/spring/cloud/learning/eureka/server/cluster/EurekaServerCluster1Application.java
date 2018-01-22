package com.jiangli.spring.cloud.learning.eureka.server.cluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerCluster1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerCluster1Application.class, args);
    }
}