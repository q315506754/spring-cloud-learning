package com.jiangli.spring.cloud.learning.rest.test;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // http://localhost:8080/hello
    @RequestMapping("/hello")
    public String index() {
        return "RestController Greetings from Spring Boot!";
    }

    // http://localhost:8080/hello2/123/a啊b吧
    @RequestMapping("/hello2/{id}/{name}")
    public String rest(@PathVariable("id") String IIDD,@PathVariable String name) {
        return "RestController Greetings from Spring Boot!"+IIDD+" "+name;
    }

}