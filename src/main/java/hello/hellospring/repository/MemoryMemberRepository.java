package hello.hellospring.repository;

import org.springframework.boot.autoconfigure.hateoas.HateoasProperties;

import java.util.*;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;


public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();  //저장하기 위함
    private static long sequence = 0L; //키값 생성


    @Override
    public hello.hellospring.domain.Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<hello.hellospring.domain.Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<hello.hellospring.domain.Member> findByName(String name) {
        return store.values().stream()
                .filter(member->member.getName().equals(name)) //맞는 이름이 나오면 반환시켜준다.
                .findAny();
    }

    @Override
    public List<hello.hellospring.domain.Member> findAll() {
        return new ArrayList<>(store.values());
    }
    public void clearStore(){
        store.clear();
    }

}
