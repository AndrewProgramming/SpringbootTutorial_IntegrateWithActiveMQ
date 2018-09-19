package com.andrewprogramming.springbootmq;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

@SpringBootApplication
public class SpringbootmqApplication {

  @Autowired
  ActiveMQClient client;

  @PostConstruct
  public void init() {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    for (int i = 0; i < 10000; i++) {
      client.send("发送消息----zhisheng-----");
    }
    stopWatch.stop();
    System.out.println("发送消息耗时: " + stopWatch.getTotalTimeMillis());
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringbootmqApplication.class, args);
  }
}
