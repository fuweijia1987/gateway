package com.example.serverdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class Serverdemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Serverdemo2Application.class, args);
    }

}
