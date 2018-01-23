package com.jiangli.spring.cloud.learning.stream.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;


@Configuration
@EnableAutoConfiguration
@EnableBinding({PrintSink.Read.class,PrintSink.Write.class})
public class PrintSink {

  @Autowired
  private Read read;
  //@Autowired
  //private Read2 read2;

  @Autowired
  private Write write;

  // exchange input -> consume -> exchange input2
  // exchange input2 -> consume 2
  // exchange input2 -> consume 3
  interface Read{
    String name = "input";

    @Input(Read.name)
    SubscribableChannel input();
  }
  interface Write{
    String name = "input2";

    @Output(Write.name)
    //SubscribableChannel output();
    MessageChannel output();//不会报错
  }


  public static void main(String[] args) {
    SpringApplication.run(PrintSink.class, args);
  }

  @StreamListener(Read.name)
  @SendTo(Write.name)
  public String consume(String str) {
      System.out.println(str);
      return str+"(from)StreamListener";
  }

  @StreamListener(Write.name)
  public void consume2(String str) {
      System.out.println("consume2:"+str);
  }
  @StreamListener(Write.name)
  public void consume3(String str) {
      System.out.println("consume3:"+str);
  }

  @Bean
  @InboundChannelAdapter(value = Read.name, poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
  public MessageSource<String> timerMessageSource() {
    return () -> {
      String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").format(new Date());
      System.out.println("p:"+format);
      return new GenericMessage<>(format);
    };
  }

  @Bean
  public EmbeddedServletContainerFactory func() {
    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
    factory.setPort(8072);
    return factory;
  }
}