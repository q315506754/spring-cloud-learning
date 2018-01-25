package com.jiangli.spring.cloud.learning.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@RestController
//@PropertySource("classpath:a1p2pl3ic4ati5on.properties")
public class ConfigClientMain {

    @Value("${auth.username}")
    String name = "World";

    @Value("${jdbcUrl}")
    String jdbcUrl;

    @Value("${jmsUrl}")
    String jmsUrl ;


    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain.class, args);
    }

    /**
     * http://localhost:8081/
     * @return
     */
    @RequestMapping("/")
    public String home() {
        System.out.println(jdbcUrl);
        System.out.println(jmsUrl);
        System.out.println(name);
        return "ClientMain Hello " + name;
    }

    @Bean
    public EmbeddedServletContainerFactory func() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8081);

        return factory;
    }
}