package com.jiangli.spring.cloud.learning.stream.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


@Configuration
@EnableAutoConfiguration
@EnableBinding(TransformProcessor.ReadAndWrite.class)
public class TransformProcessor {

    interface ReadAndWrite{
        String READFROM = "output";
        String WRITETO = "input";

        @Input(ReadAndWrite.READFROM)
        SubscribableChannel inputFrom();

        @Output(ReadAndWrite.WRITETO)
        MessageChannel outputTo();
    }

    public static void main(String[] args) {
        SpringApplication.run(TransformProcessor.class, args);
    }


    @Transformer(inputChannel = ReadAndWrite.READFROM, outputChannel = ReadAndWrite.WRITETO)
    public Object transform(String message) {
        System.out.println(message);
        return message.toUpperCase()+"...";
    }

    @Bean
    public EmbeddedServletContainerFactory func() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8071);
        return factory;
    }
}