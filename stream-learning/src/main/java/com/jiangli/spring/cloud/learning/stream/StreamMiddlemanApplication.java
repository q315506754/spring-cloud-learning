package com.jiangli.spring.cloud.learning.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

import javax.annotation.PostConstruct;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableBinding(Processor.class)
public class StreamMiddlemanApplication {

    @Autowired
    private MessageChannel output;
    @Autowired
    private SubscribableChannel input;

    public static void main(String[] args) {
        SpringApplication.run(StreamMiddlemanApplication.class, args);
    }

    @PostConstruct
    public void sss() {
        input.subscribe(message -> {
                    System.out.println("ssss");
                    output.send(message);
                }
        );
    }


    //@Bean
    //@InboundChannelAdapter(value = Processor.OUTPUT)
    //public MessageSource<String> timerMessageSource() {
    //    return () -> new GenericMessage<>(new SimpleDateFormat().format(new Date()));
    //}

    @Bean
    public EmbeddedServletContainerFactory func() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8072);
        return factory;
    }
}