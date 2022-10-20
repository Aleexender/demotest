package com.example.demotest.repository;

import com.example.demotest.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository(); //전체 클래스를 테스트를 할수있다 , 순서가 보장이 안댐, 순서 의존도로 설계하면 안댐

    @AfterEach
    public void afterEach(){        // 테스트는 서로 순서와 관계없이, 의존관계없이 설계가 되야함, 그러기 위해서는 하나의 테스트를 끝날때마다 저장소나, 공용데이터를 클리어를 해줘야함
        repository.clearStore();
    }


    @Test
    public void save(){ //메인 메소드 쓰는거와 비슷하다
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        repository.findById(member.getId()).get(); // 겟으로 바로 꺼내는건 좋은건 아님 *테스트 에서만! 맨 끝에 겟은 뭐의 get이지?
        assertArrayEquals(new Member[]{member}, null);
//        Assertions.assertThat(member).isEqulTo(result); // 아마도 버전이 달라서 그런듯
    }



    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        Member result =repository.finByName("spring1").get();

//        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void finAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();

//        assertThat(result.size()).equalTo(2);
    }
}
