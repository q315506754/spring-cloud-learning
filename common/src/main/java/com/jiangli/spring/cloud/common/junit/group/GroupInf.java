package com.jiangli.spring.cloud.common.junit.group;


import com.jiangli.spring.cloud.common.junit.group.invoker.GroupInvoker;

/**
 * @author Jiangli
 * @date 2017/12/28 9:31
 */
public interface GroupInf {
    GroupInvoker[] splitGroup(String[] params);
}
