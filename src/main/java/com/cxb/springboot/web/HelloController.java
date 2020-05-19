package com.cxb.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping()
    public String hello(){
        return "hello feign ！";
    }

}
