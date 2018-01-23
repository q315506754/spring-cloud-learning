package com.jiangli.spring.cloud.learning.stream.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;


@Configuration
@EnableAutoConfiguration
@EnableBinding(Source.class)
public class TimerSource {

  public static void main(String[] args) {
    SpringApplication.run(TimerSource.class, args);
  }

  @Bean
  @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "3000", maxMessagesPerPoll = "1"))
  public MessageSource<String> timerMessageSource() {
    return () -> {
      String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").format(new Date());
      System.out.println(format);
      return new GenericMessage<>(format);
    };
  }

  @Bean
  public EmbeddedServletContainerFactory func() {
    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
    factory.setPort(8070);
    return factory;
  }
}