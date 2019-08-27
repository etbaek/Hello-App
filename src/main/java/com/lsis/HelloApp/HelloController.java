package com.lsis.HelloApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${welcome.message}")
    String helloMsg;

    @GetMapping("/")
    public String Hello() {
        return helloMsg;
    }
}
