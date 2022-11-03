package com.example.demotest.controller;

import com.example.demotest.domain.Member;
import com.example.demotest.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberContorller {


    private final MemberService memberService; // private 뒤에 @Autowired 를 넣으면 필드 주입, 필드 주입은 바꿀수없기때문에 비추

    @Autowired // 연결을 시켜주는것 - 
    public MemberContorller(MemberService memberService) {

        this.memberService = memberService;
    }


    @GetMapping("/members/new") //get 방식 , get은 조회할때 씀
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") //데이터를 등록할때 post를 씀
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

//        System.out.println("member = " + member.getName());

        memberService.join(member);
        return "redirect:/";       //홈 화면으로 보내버리는거
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members); // 멤버라는 이름으로 멤버객체를 추가
        return "members/memberList";

    }
}