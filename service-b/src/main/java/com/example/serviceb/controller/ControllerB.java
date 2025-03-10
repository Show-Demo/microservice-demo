package com.example.serviceb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerB {

    private static final Logger logger = LogManager.getLogger(ControllerB.class);

    @GetMapping("/b")
    public String respond() {
        logger.info("Service B: 接收到 /b 请求");
        return "Hello from Service B";
    }
}
