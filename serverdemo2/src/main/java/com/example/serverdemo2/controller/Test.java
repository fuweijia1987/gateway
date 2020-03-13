package com.example.serverdemo2.controller;

import com.example.serverdemo2.feign.ProductClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Test {

    @Autowired
    private ProductClient productClient;

    @RequestMapping(path = "/api/v1/test1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @HystrixCommand(fallbackMethod = "fallback")
   // @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" ,value = "3000")
    public String feign(){
        System.out.println("master");
        System.out.println("testController");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String s = productClient.findById("11111");
        return s;
    }


    private String fallback(){
        Map<String, Object> msg = new HashMap<>();
        msg.put("code", -1);
        msg.put("msg", "服务已经熔断，稍等重试");
        return "服务已经熔断，稍等重试";
    }
}
