package myboard.spring.repository;

import myboard.spring.domain.Grade;
import myboard.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByUserName(String userName);
    Optional<Member> findByGrade(Grade grade);
    List<Member> findAll();
    List<Member> findByPage(Integer pageNo);

}
