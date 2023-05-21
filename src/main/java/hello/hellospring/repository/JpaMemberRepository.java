package hello.hellospring.repository;
//jpa
import hello.hellospring.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional //JPA에서는 항상 트랜잭셔널을 올려주어야 한다.
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) { //엔티티매니져로 동작한다. 주입받았기 떄문에 자동으로 생성된다.
        this.em = em;
    }

    @Override
    public Member save(Member member) { //insert 쿼리를 만들어서 알아서 집어넣음.
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member =  em.find(Member.class,id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result =  em.createQuery("select m from Member m where m.name = :name",Member.class)
                .setParameter("name",name)  //jpql
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m" ,Member.class)
                .getResultList();//객체를 대상으로 쿼리를 날린다.
    }
}
