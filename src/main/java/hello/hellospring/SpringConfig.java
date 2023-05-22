package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration  //읽고 bean에 등록해주는 파일
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; //SpringDataJpaMemberRepository를 만들어 놓음.
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

/*    @Bean //AOP를 등록한다. or @Componet 스캔을 올린다.
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }*/

/*    @Bean
    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource); 기본 jdbc사용
        //return new JdbcTemplateMemberRepository(dataSource); jdbc템플릿 사용
        //return new JpaMemberRepository(em); jpa 사용

    }*/
}
