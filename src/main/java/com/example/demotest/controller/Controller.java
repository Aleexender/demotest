package com.example.demotest.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); // data라는이름으로 hello 값을 넣는다
        return "Hello";
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model){ // 웹 에서 파라메터를 받는법
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // HTTP 바디부위에 이데이터를 직접 넣어준다
    public String helloString(@RequestParam("name")String name){
        return "hello " + name;
    }

    @GetMapping("hello-api") //데이터를 놓고 싶을때 API방식
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() { // getter 자바 빈 표준 방식 = 게터 세터 or 프로포티 사용 방식
            return name;
        }

        public void setName(String name) { // setter
            this.name = name;
        }
    }
}
