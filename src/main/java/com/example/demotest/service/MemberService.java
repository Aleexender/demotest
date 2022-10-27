package com.example.demotest.service;

import com.example.demotest.domain.Member;
import com.example.demotest.repository.MemberRepository;
import com.example.demotest.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service // 스프링이 올라올떄, 스프링이 맴버서비스를 스프링 컨테이너에 넣어줌
public class  MemberService { // 비지니스에 갖고있는 용어를 써야함

    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) { // 멤버 서비스입장에서 보면 멤버리파지토리 외부에서 넣어준다 = DI
        this.memberRepository = memberRepository; // 생성자 주입
    }

    // 회원 가입
    public Long join(Member member){
        //같은 이름이 있는 중복회원 X
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
         memberRepository.finByName(member.getName())
        .ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }
    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
