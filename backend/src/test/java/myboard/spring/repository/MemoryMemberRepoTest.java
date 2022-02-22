package myboard.spring.repository;

import myboard.spring.domain.Grade;
import myboard.spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepoTest {

    MemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        if (memberRepository instanceof MemoryMemberRepository) {
            ((MemoryMemberRepository) memberRepository).clear();
        }
    }

    @Test
    public void save() {
        // given
        Member member = new Member("jaemin", "pw", Grade.User);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        Optional<Member> foundMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(foundMember).isNotEmpty();
        Assertions.assertThat(foundMember.get()).isEqualTo(savedMember);
    }

    @Test
    public void existById() {
        // given
        Member member = new Member("jaemin", "pw", Grade.User);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        Boolean existOrNot = memberRepository.existsById(savedMember.getId());
        Assertions.assertThat(existOrNot).isTrue();
    }

    @Test
    public void findByUsername() {
        // given
        Member member = new Member("jaemin", "pw", Grade.User);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        Optional<Member> foundMember = memberRepository.findByUserName(savedMember.getUserName());
        Assertions.assertThat(foundMember).isNotEmpty();
        Assertions.assertThat(foundMember.get()).isEqualTo(savedMember);
    }

    @Test
    public void findAll() {
        // given
        Member member1 = new Member("jaemin", "pw1", Grade.User);
        Member member2 = new Member("yoolmoo", "pw2", Grade.User);
        Member member3 = new Member("heedong", "pw3", Grade.Administrator);

        // when
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        // then
        List<Member> foundMembers = memberRepository.findAll();
        Assertions.assertThat(foundMembers).hasSize(3);
    }

    @Test
    public void findByPage() {
        // TBD
        // given

        // when

        // then
    }

    @Test
    public void findByGrade() {
        // given
        Member member1 = new Member("jaemin", "pw1", Grade.User);
        Member member2 = new Member("yoolmoo", "pw2", Grade.User);
        Member member3 = new Member("heedong", "pw3", Grade.Administrator);

        // when
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        // then
        List<Member> foundMembers = memberRepository.findByGrade(Grade.User);
        Assertions.assertThat(foundMembers).hasSize(2);
        foundMembers = memberRepository.findByGrade(Grade.Administrator);
        Assertions.assertThat(foundMembers).hasSize(1);
    }

    @Test
    public void deleteById() {
        // given
        Member member1 = new Member("jaemin", "pw1", Grade.User);
        Member member2 = new Member("yoolmoo", "pw2", Grade.User);
        Member member3 = new Member("heedong", "pw3", Grade.Administrator);

        // when
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        // then
        memberRepository.deleteById(member1.getId());
        Assertions.assertThat(memberRepository.findAll()).hasSize(2);
        memberRepository.deleteById(member2.getId());
        Assertions.assertThat(memberRepository.findAll()).hasSize(1);
    }

}
