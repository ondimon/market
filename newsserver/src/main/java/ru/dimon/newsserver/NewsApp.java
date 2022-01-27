package ru.dimon.newsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class NewsApp {

    public static void main(String[] args) {
        SpringApplication.run(NewsApp.class, args);
    }

}
