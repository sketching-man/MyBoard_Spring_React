package myboard.spring.repository;

import myboard.spring.domain.Article;
import myboard.spring.domain.Grade;
import myboard.spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class MemoryArticleRepoTest {

    MemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {

    }

    @Test
    public void save() {
        // given
        Member member = new Member("jaemin", "asdf", Grade.User);
        Article article = new Article("hello", "my name is jaemin", member, LocalDateTime.now());

        // when


        // then
    }

}
