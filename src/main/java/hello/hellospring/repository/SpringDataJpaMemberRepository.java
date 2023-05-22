package hello.hellospring.repository;
// 스프링 JPA
import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository {
    //JpaRepository를 extends하면 알아서 구현체를 만든다.
    // select m from Member m where m.name=?
    @Override
    Optional<Member> findByName(String Name);

    //Optional<Member> findByNameAndId(String Name,int Id); ->정해져 있는 규칙이다. (인터페이스만으로 CRUD가 가능하다.)

}
