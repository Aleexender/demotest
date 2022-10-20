package com.example.demotest.repository;

import com.example.demotest.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 0,1,2 키값을 생성

