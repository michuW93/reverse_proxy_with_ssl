package com.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestWeb {

    @GetMapping("/testWeb")
    public String testWeb(){
        return "testWeb";
    }
}
