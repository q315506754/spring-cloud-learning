package com.jiangli.spring.cloud.learning.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Jiangli
 * @date 2018/1/23 19:22
 */
@Component
public class CmBean {
    private  Logger log = LoggerFactory.getLogger(this.getClass());

    public CmBean() {
        System.out.println("CmBean construct...");
        log.trace("construct...");
        log.debug("construct...");
        log.info("construct...");
        log.warn("construct...");
    }
}
