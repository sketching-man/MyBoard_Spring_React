package myboard.spring.repository;

import myboard.spring.domain.Grade;
import myboard.spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestEntityManager
@Transactional
public class JpaMemberRepoTest {

    @Autowired
    private MemberRepository repo;

    @Test
    public void save() {
        // given
        Member member = Member.builder()
                .userName("jaemin")
                .password("pw")
                .grade(Grade.Administrator)
                .build();

        // when
        Member savedMember = repo.save(member);

        // then
        Assertions.assertThat(savedMember.getUserName()).isEqualTo("jaemin");
    }

    @Test
    public void existById() {
        // given
        Member member = Member.builder()
                .userName("jaemin")
                .password("pw")
                .grade(Grade.Administrator)
                .build();
        Member savedMember = repo.save(member);

        // when
        var result = repo.existsById(savedMember.getId());

        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void findById() {
        // given
        Member member = Member.builder()
                .userName("jaemin")
                .password("pw")
                .grade(Grade.Administrator)
                .build();
        Member savedMember = repo.save(member);

        // when
        var result = repo.findById(savedMember.getId());

        // then
        Assertions.assertThat(result).isPresent();
        Assertions.assertThat(result.get().getId()).isEqualTo(savedMember.getId());
    }

    @Test
    public void findByUserName() {
        // given
        Member member = Member.builder()
                .userName("jaemin")
                .password("pw")
                .grade(Grade.Administrator)
                .build();
        Member savedMember = repo.save(member);

        // when
        var result = repo.findByUserName("jaemin");

        // then
        Assertions.assertThat(result).isPresent();
        Assertions.assertThat(result.get().getId()).isEqualTo(savedMember.getId());
    }

    @Test
    public void findAll() {
        // given
        Member member1 = Member.builder()
                .userName("jaemin")
                .password("pw")
                .grade(Grade.Administrator)
                .build();
        Member savedMember1 = repo.save(member1);

        Member member2 = Member.builder()
                .userName("heedong")
                .password("pw")
                .grade(Grade.User)
                .build();
        Member savedMember2 = repo.save(member2);

        // when
        var result = repo.findAll();

        // then
        Assertions.assertThat(result).hasSize(2).contains(savedMember1).contains(savedMember2);
    }

    @Test
    public void findByPage() {
        // given
        Member member1 = Member.builder()
                .userName("jaemin")
                .password("pw")
                .grade(Grade.Administrator)
                .build();
        Member savedMember1 = repo.save(member1);

        Member member2 = Member.builder()
                .userName("heedong")
                .password("pw")
                .grade(Grade.User)
                .build();
        Member savedMember2 = repo.save(member2);

        // when
        var result = repo.findByPage(1);

        // then
        Assertions.assertThat(result).hasSize(2).contains(savedMember1).contains(savedMember2);
    }

    @Test
    public void findByGrade() {
        // given
        Member member1 = Member.builder()
                .userName("jaemin")
                .password("pw")
                .grade(Grade.Administrator)
                .build();
        repo.save(member1);

        Member member2 = Member.builder()
                .userName("heedong")
                .password("pw")
                .grade(Grade.User)
                .build();
        Member savedMember2 = repo.save(member2);

        // when
        var result = repo.findByGrade(Grade.User);

        // then
        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result.get(0)).isEqualTo(savedMember2);
    }

    @Test
    public void deleteById() {
        // given
        Member member1 = Member.builder()
                .userName("jaemin")
                .password("pw")
                .grade(Grade.Administrator)
                .build();
        Member savedMember1 = repo.save(member1);

        Member member2 = Member.builder()
                .userName("heedong")
                .password("pw")
                .grade(Grade.User)
                .build();
        Member savedMember2 = repo.save(member2);

        // when
        repo.deleteById(savedMember1.getId());
        var result = repo.findAll();

        // then
        Assertions.assertThat(result).hasSize(1).contains(savedMember2);
    }

    @Test
    public void deleteByName() {
        // given
        Member member1 = Member.builder()
                .userName("jaemin")
                .password("pw")
                .grade(Grade.Administrator)
                .build();
        Member savedMember1 = repo.save(member1);

        Member member2 = Member.builder()
                .userName("heedong")
                .password("pw")
                .grade(Grade.User)
                .build();
        Member savedMember2 = repo.save(member2);

        // when
        repo.deleteByName(savedMember1.getUserName());
        var result = repo.findAll();

        // then
        Assertions.assertThat(result).hasSize(1).contains(savedMember2);
    }

}
