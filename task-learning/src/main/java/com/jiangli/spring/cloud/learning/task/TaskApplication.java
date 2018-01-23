package com.jiangli.spring.cloud.learning.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@EnableTask
public class TaskApplication {

	@Bean
    public CommandLineRunner commandLineRunner() {
		return strings ->
				System.out.println("Executed at :" + Arrays.toString(strings)+
				      new SimpleDateFormat().format(new Date()));
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
}