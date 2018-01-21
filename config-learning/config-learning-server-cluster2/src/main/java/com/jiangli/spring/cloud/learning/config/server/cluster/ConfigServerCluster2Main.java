package com.jiangli.spring.cloud.learning.config.server.cluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerCluster2Main {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerCluster2Main.class, args);
    }
}