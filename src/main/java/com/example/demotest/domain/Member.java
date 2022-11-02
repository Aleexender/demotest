package com.example.demotest.domain;

public class Member {

    private Long id; // 이메일 값 - 시스템이 저장하는 아이디
    private String name; // 이름

    public Long getId() {
        return id;
    } // 게터, 세터 접근방식

    public void setId(Long id) {
        this.id = id;
    } // 게터, 세터 접근방식

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
