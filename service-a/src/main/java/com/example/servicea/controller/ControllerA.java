package com.example.servicea.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerA {

    private static final Logger logger = LogManager.getLogger(ControllerA.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 接收 /a 请求后调用 Service B 的 /b 接口（通过 Eureka 服务发现）
     */
    @GetMapping("/a")
    public String callServiceB() {
        logger.info("Service A: 接收到 /a 请求");
        // 使用服务名 "service-b" 调用 Service B 的 /b 接口
        String response = restTemplate.getForObject("http://service-b/b", String.class);
        logger.info("Service A: 从 Service B 获取响应：{}", response);
        return "Service A 调用 Service B 响应 -> " + response;
    }
}
