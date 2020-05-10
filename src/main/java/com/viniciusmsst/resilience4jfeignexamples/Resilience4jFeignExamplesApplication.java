package com.viniciusmsst.resilience4jfeignexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Resilience4jFeignExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(Resilience4jFeignExamplesApplication.class, args);
    }

}
