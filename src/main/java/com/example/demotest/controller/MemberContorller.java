package com.example.demotest.controller;

import com.example.demotest.domain.Member;
import com.example.demotest.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberContorller {

    private final MemberService memberService; // private 뒤에 @Autowired 를 넣으면 필드 주입, 필드 주입은 바꿀수없기때문에 비추

    @Autowired // 연결을 시켜주는것
    public MemberContorller(MemberService memberService) {

        this.memberService = memberService;
    }


    @GetMapping("/members/new") //get 방식 , get은 조회할때 씀
    public String createForm() {
        return "members/createMemberForm";
    }
