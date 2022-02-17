package myboard.spring.repository;

import myboard.spring.domain.Grade;
import myboard.spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static final Map<Long, Member> memoryStore = new HashMap<>();
    private static Long memoryIndex = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++memoryIndex);
        memoryStore.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(memoryStore.get(id));
    }

    @Override
    public Optional<Member> findByUserName(String userName) {
        return memoryStore.values().stream()
                .filter(member -> member.getUserName().equals(userName))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(memoryStore.values());
    }

    @Override
    public List<Member> findByPage(Integer pageNo) {
        return null;
    }

    @Override
    public List<Member> findByGrade(Grade grade) {
        return memoryStore.values().stream()
                .filter(member -> member.getGrade().equals(grade))
                .collect(Collectors.toList());
    }

    public void clear() {
        memoryStore.clear();
    }

}
