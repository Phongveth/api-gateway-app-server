package com.la.apigatewayappserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "Calling from interal API Gateway controler";
    }

    @GetMapping("/noAuth")
    public String noAuth(){
        return "Calling from interal API Gateway controler No Auth";
    }
}
