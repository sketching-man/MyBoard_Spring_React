package myboard.spring.repository;

import myboard.spring.domain.Grade;
import myboard.spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestEntityManager
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
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
        Assertions.assertThat(member.getUserName()).isEqualTo(savedMember.getUserName());
    }

}
