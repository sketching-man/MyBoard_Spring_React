package myboard.spring.repository;

import myboard.spring.domain.Grade;
import myboard.spring.domain.Member;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestEntityManager
@Transactional
public class JpaArticleRepoTest {

    @Autowired
    private ArticleRepository repo;
    @Autowired
    private MemberRepository memberRepository;

    @BeforeAll
    public void beforeAll() {
        Member testMember = Member.builder()
                .userName("jaemin")
                .password("pw")
                .grade(Grade.Administrator)
                .build();
        memberRepository.save(testMember);
    }

    @Test
    public void save() {
        // given

        // when

        // then
    }

    @AfterAll
    public void afterAll() {
        memberRepository.deleteByName("jaemin");
    }

}
