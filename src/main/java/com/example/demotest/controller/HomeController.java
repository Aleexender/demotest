package com.example.demotest.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // 이거 떄문에 index.html이 무시된다
    public String home() {
        return "home";
    }
}
