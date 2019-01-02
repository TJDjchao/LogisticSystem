package com.neo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.neo.mapper")
public class SiteRouteService {

    public static void main(String[] args) {
        SpringApplication.run(SiteRouteService.class, args);
    }
}
