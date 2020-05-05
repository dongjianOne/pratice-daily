package com.dong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PraticeDailyApplication {


    public static void main(String[] args) {
        SpringApplication.run(PraticeDailyApplication.class, args);
    }

}
