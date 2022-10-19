package com.example.demotest.service;

import com.example.demotest.domain.Member;
import com.example.demotest.repository.MemberRepository;
import com.example.demotest.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService { // 비지니스에 갖고있는 용어를 써야함

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원 가입
    public Long join(Member member){
        //같은 이름이 있는 중복회원 X
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }