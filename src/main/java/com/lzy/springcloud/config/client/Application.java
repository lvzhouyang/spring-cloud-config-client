package com.lzy.springcloud.config.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liaokailin on 16/4/28.
 */
@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
@RestController
public class Application {
    @Value("${name:World!}")
    String bar;

    @Autowired
    private ConfigProperties configProperties;

    @RequestMapping("/")
    String hello() {
        return "Hello " + configProperties.getFoo() + "!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}