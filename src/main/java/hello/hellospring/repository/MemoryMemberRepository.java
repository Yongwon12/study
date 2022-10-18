package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // Map => key, value 를 사용하여 정보를 찾기
    private static long sequence = 0L; // sequence는 key값을 생성시켜줌

    @Override
    public Member save(Member member) { // member id를 저장
        member.setId(++sequence); // member 늘어나면 sequence(id 번호)도 늘어남
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));// store에서 id를 가져오는데 null일 수가 있기 때문에 Optional을 사용하여 조기에 문제제거
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // stream() -> 루프
                .filter(member -> member.getName().equals(name)) // member.getName() 이 파라미터로 넘어온 name과 같은지 확인
                .findAny(); // 하나라도 찾는 것 만약 같은게 없다면 Optional에서의 null이 반환됨
    }

    @Override
    public List<Member> findAll() { // Member 가 List로 되어있음
        return new ArrayList<>(store.values()); //store에 있는 values()가 멤버임
    }

    public void clearStore(){ // 저장소 클리어를 위한 것
        store.clear();
    }
}
