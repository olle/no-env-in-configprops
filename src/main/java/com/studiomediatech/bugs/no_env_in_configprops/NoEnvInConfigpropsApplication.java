package com.studiomediatech.bugs.no_env_in_configprops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.event.EventListener;

@EnableConfigurationProperties(MyConfigurationProperties.class)
@SpringBootApplication
public class NoEnvInConfigpropsApplication {

  @Autowired MyConfigurationProperties myConfigurationProperties;

  public static void main(String[] args) {
    SpringApplication.run(NoEnvInConfigpropsApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void ready() {
    System.out.println("READY WITH PROPERTIES " + myConfigurationProperties.getProps());
  }
}
