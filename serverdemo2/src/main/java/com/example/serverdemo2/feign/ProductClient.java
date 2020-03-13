package com.example.serverdemo2.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "server-demo")
public interface ProductClient {

    @GetMapping("/api/v1/test2")
    String findById(@RequestParam(value = "id") String id);
}
