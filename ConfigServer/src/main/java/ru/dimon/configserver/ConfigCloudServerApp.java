package ru.dimon.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigCloudServerApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCloudServerApp.class, args);
    }

}
