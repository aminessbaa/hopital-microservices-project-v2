package com.microservice.patient.controller.config;


import org.springframework.beans.factory.annotation.Value;


import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {


    @Value("${global.params.p1}")
    private int p1;

    @Value("${global.params.p2}")
    private int p2;

    @Value("${patient.params.x}")
    private int x;

    @Value("${patient.params.y}")
    private int y;

    @GetMapping("/test-config")
    public Map<String,Integer> testConfig() {
        return Map.of("p1", p1, "p2", p2, "x", x, "y", y);
    }

//    @GetMapping("/global-config")
//    public String getGlobalConfig() {
//        return "p1="+this.globalConfig.getP1()+"        p2="+this.globalConfig.getP2();
//    }
}