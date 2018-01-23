package com.jiangli.spring.cloud.learning.stream.integration;

import org.springframework.stereotype.Component;

/**
 * @author Jiangli
 * @date 2018/1/23 10:22
 */
@Component
public class CommonBean {
    public CommonBean() {
        System.out.println("!!!!!!!!!!common bean..!");
    }
}
