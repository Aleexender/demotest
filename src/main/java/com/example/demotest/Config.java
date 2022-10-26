package com.example.demotest;

import com.example.demotest.repository.MemberRepository;
import com.example.demotest.repository.MemoryMemberRepository;
import com.example.demotest.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration

public class Config {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}