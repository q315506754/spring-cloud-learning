package com.jiangli.spring.cloud.common.junit.data.handler;


import com.jiangli.spring.cloud.common.junit.InvokeContext;
import com.jiangli.spring.cloud.common.junit.data.DataCollector;

/**
 * @author Jiangli
 * @date 2017/12/28 11:18
 */
public interface DataHandler {
    void handler(InvokeContext context, DataCollector model);
}
