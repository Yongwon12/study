package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 중복 저장 회원 방지 저장소 클리어
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result); // spring 회원의 정보를 저장
    }
    @Test
    public void findByName(){ // findByName이 동작하는지 확인
        Member member1 = new Member();
        member1.setName("spring1"); // spring1 회원가입
        repository.save(member1); // member1 정보저장

        Member member2 = new Member();
        member2.setName("spring2"); // spring2 회원가입
        repository.save(member2); // member2 정보저장

        Member result = repository.findByName("spring1").get(); // spring1 회원의 정보를 get

        assertThat(result).isEqualTo(member1); // spring1 회원의 정보를 get한(저장된) 값이 입력값과 같은지 확인
    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);  // 실제 회원가입한 인원수를  저장된 개수와 비교
    }
}
