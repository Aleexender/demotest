package com.example.demotest.repository;

import com.example.demotest.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> finByName(String name);

    List<Member> findAll();
}
