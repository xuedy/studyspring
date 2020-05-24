package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
        ConfigurableApplicationContext ca= SpringApplication.run(DemoApplication.class, args);
        String[] names=ca.getBeanDefinitionNames();
        for (String s:names) {
            System.out.println(s);
        }
    }

}
