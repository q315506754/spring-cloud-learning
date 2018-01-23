package com.jiangli.spring.cloud.learning.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@EnableAutoConfiguration
@EnableBinding(Sink.class)
public class StreamConsumerApplication {

    @Autowired
    private Sink sink;

    @Autowired
    private SubscribableChannel input;

  public static void main(String[] args) {
    SpringApplication.run(StreamConsumerApplication.class, args);
  }

      //@StreamListener(Sink.INPUT)
      //public void processVote(String str) {
      //    System.out.println(str);
      //}
    
    @Bean
    public EmbeddedServletContainerFactory func() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8071);
        return factory;
    }

    @PostConstruct
    public void sss() {
        SubscribableChannel linput = sink.input();
        System.out.println(linput);
        System.out.println(input);
        System.out.println(input==linput);
        linput.subscribe(message -> {
            Object payload = message.getPayload();
            System.out.println(payload);
        });
    }
}