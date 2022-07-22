package myboard.spring.repository;

import lombok.RequiredArgsConstructor;
import myboard.spring.domain.Grade;
import myboard.spring.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(em.find(Member.class, id));
    }

    @Override
    public Optional<Member> findByUserName(String userName) {
        return em.createQuery("SELECT m FROM Member m WHERE userName = :userName", Member.class)
                .setParameter("userName", userName)
                .getResultStream()
                .findFirst();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }

    @Override
    public List<Member> findByPage(Integer pageNo) {
        // TODO: 페이지 순서대로 20개씩 잘라서 보여줘야 함. 순서는 id 기준
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }

    @Override
    public List<Member> findByGrade(Grade grade) {
        return em.createQuery("SELECT m FROM Member m WHERE m.grade = :grade", Member.class)
                .setParameter("grade", grade)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(em::remove);
    }

    @Override
    public void deleteByName(String userName) {
        findByUserName(userName).ifPresent(em::remove);
    }

}
