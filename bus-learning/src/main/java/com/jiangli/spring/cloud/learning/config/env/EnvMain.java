package com.jiangli.spring.cloud.learning.config.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@EnableAutoConfiguration
@RestController
@PropertySource("classpath:aa/inner.properties")
public class EnvMain {

    @Value("${auth.username}")
    String name = "World";

    @Value("${abc}")
    String inner;

    @Autowired
    ApplicationContext context;

    @Autowired
    Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(EnvMain.class, args);
    }

    /**
     * http://localhost:8080/
     *
     * @return
     */
    @RequestMapping("/")
    public String home() {
        System.out.println(inner);
        System.out.println(context);
        System.out.println(environment);
        System.out.println(environment.getProperty("auth.username"));
        System.out.println(environment.resolvePlaceholders("username is : ${auth.username}"));
        return "EnvMain Hello " + name;
    }

    @Bean
    public EmbeddedServletContainerFactory func() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8080);
        return factory;
    }

}