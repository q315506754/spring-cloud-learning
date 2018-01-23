package com.jiangli.spring.cloud.learning.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"spring.cloud.task.closecontext_enabled=false"})
public class DemoApplicationTests {

	@Test
    public void contextLoads() {
	//your test here
		System.out.println("aaa");
	}

}