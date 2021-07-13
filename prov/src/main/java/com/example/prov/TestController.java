package com.example.prov;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/testProv")
    public String testProv() {
        return "testProv";
    }
}
