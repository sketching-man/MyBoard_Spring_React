package myboard.spring.repository;

import myboard.spring.domain.Grade;
import myboard.spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

//@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static final Map<Long, Member> memoryStore = new HashMap<>();
    private static Long memoryIndex = 0L;

    @Override
    public Member save(Member member) {
        if (!memoryStore.containsKey(member.getId()))
            member.setId(++memoryIndex);
        memoryStore.put(member.getId(), member);
        return member;
    }

    @Override
    public boolean existsById(Long id) {
        return memoryStore.containsKey(id);
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
        // TODO: To be developed
        return findAll();
    }

    @Override
    public List<Member> findByGrade(Grade grade) {
        return memoryStore.values().stream()
                .filter(member -> member.getGrade().equals(grade))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        memoryStore.remove(id);
    }

    @Override
    public void deleteByName(String userName) {
        findByUserName(userName).ifPresent(value -> memoryStore.remove(value.getId()));
    }

    public void clear() {
        memoryStore.clear();
    }

}
