package myboard.spring.repository;

import myboard.spring.domain.Grade;
import myboard.spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByUserName(String userName) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByGrade(Grade grade) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public List<Member> findByPage(Integer pageNo) {
        return null;
    }

}
