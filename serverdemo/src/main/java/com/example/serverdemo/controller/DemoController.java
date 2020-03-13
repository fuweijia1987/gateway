package com.example.serverdemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
public class DemoController {

    @RequestMapping(path = "/api/v1/test2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String test() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return "SUCCESS";
    }

}
