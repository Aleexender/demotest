package com.example.demotest.controller;

import com.example.demotest.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberContorller {

    private final MemberService memberService;

    @Autowired // 연결을 시켜주는것
    public MemberContorller(MemberService memberService) {
        this.memberService = memberService;
    }
}
