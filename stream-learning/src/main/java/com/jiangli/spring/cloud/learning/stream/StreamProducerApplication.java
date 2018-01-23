package com.jiangli.spring.cloud.learning.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableBinding(Source.class)
public class StreamProducerApplication {

    @Autowired
    private Source source;

    @Autowired
    private MessageChannel  output;

    public static void main(String[] args) {
        SpringApplication.run(StreamProducerApplication.class, args);
    }

    @PostConstruct
    public void sss() {
        new Thread(() -> {
            while (true) {
                try {
                    MessageChannel loutput = source.output();
                    System.out.println(loutput);
                    System.out.println(output);
                    System.out.println(output==loutput);
                    String format = new SimpleDateFormat().format(new Date());
                    System.out.println(format);
                    output.send(new GenericMessage<>(format));
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    //@Bean
    //@InboundChannelAdapter(value = Processor.OUTPUT)
    //public MessageSource<String> timerMessageSource() {
    //    return () -> new GenericMessage<>(new SimpleDateFormat().format(new Date()));
    //}

    @Bean
    public EmbeddedServletContainerFactory func() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8070);
        return factory;
    }
}