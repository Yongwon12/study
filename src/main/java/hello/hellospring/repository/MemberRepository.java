// 가상의 저장소 역할을 수행

package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원의 정보를 저장소에 저장, 저장된 정보가 반환
    Optional<Member> findById(Long id); // 저장소의 id로 회원을 찾는 것 null일 수 있기 때문에 Optional을 사용
    Optional<Member> findByName(String name); // 저장소의 name으로 회원을 찾는 것 null일 수 있기 때문에 Optional을 사용

    List<Member> findAll(); // 모든 회원 리스트를 반환
}
