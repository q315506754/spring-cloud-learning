package com.jiangli.spring.cloud.common.test;

import org.junit.Test;
import org.springframework.util.StopWatch;

/**
 * @author Jiangli
 * @date 2018/1/23 10:42
 */
public class StopWatchTest {
    @Test
    public void test_max() {
        //StopWatch stopWatch = new StopWatch();
        StopWatch stopWatch = new StopWatch("idid");
        stopWatch.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        System.out.println(stopWatch.getTotalTimeSeconds());
        System.out.println(stopWatch.shortSummary());
        System.out.println(stopWatch.getId());
    }
    
    
    
}
