package com.neo.logisticsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class LogisticSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticSystemApplication.class, args);
    }

}

