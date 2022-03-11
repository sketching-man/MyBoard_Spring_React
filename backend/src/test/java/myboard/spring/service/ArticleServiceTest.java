package myboard.spring.service;

import myboard.spring.domain.*;
import myboard.spring.repository.ArticleRepository;
import myboard.spring.repository.MemoryArticleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    ArticleService articleService;

    @BeforeEach
    public void beforeEach() {
        Member member1 = new Member("jaemin", "pw1", Grade.User);
        Member member2 = new Member("yoolmoo", "pw2", Grade.User);
        Member member3 = new Member("heedong", "pw3", Grade.Administrator);
        Article article1 = new Article("hello", "my name is jaemin", member1, LocalDateTime.now());
        Article article2 = new Article("hi", "my name is yoolmoo", member2, LocalDateTime.now());
        Article article3 = new Article("hi hello", "my name is heedong", member3, LocalDateTime.now());

        articleRepository.save(article1);
        articleRepository.save(article2);
        articleRepository.save(article3);
    }

    @AfterEach
    public void afterEach() {
        if (articleRepository instanceof MemoryArticleRepository) {
            ((MemoryArticleRepository)articleRepository).clear();
        }
    }

    @Test
    public void write() {
        // given
        Member writer = new Member("jaemin", "asdf", Grade.User);
        Article article = new Article("hello", "my name is jaemin", writer, LocalDateTime.now());

        // when
        Long savedId = articleService.write(article);

        // then
        Assertions.assertThat(savedId).isGreaterThanOrEqualTo(1L);
        Optional<Article> foundArticle = articleRepository.findById(savedId);
        Assertions.assertThat(foundArticle).isPresent();
        Assertions.assertThat(foundArticle.get().getTitle()).isEqualTo("hello");
        Assertions.assertThat(foundArticle.get().getBody()).isEqualTo("my name is jaemin");
    }

    @Test
    public void getArticleSimples() {
        // given
        Member writer = new Member("jaemin", "asdf", Grade.User);
        Article article = new Article("hello", "my name is jaemin", writer, LocalDateTime.now());

        // when
        List<ArticleSimple> list = articleService.getArticleSimples(1);

        // then
        Assertions.assertThat(list).hasSize(3);
        articleService.write(article);
        list = articleService.getArticleSimples(1);
        Assertions.assertThat(list).hasSize(4);
    }

    @Test
    public void getArticle() {
        // given
        // when
        List<ArticleSimple> list = articleService.getArticleSimples(1);
        Long id = list.stream().findFirst().get().getId();
        String title = list.stream().findFirst().get().getTitle();
        Optional<Article> foundArticle = articleService.getArticle(id);

        // then
        Assertions.assertThat(foundArticle).isPresent();
        Assertions.assertThat(foundArticle.get().getId()).isEqualTo(id);
        Assertions.assertThat(foundArticle.get().getTitle()).isEqualTo(title);
    }

    @Test
    public void updateArticle() {
        // given
        List<ArticleSimple> list = articleService.getArticleSimples(1);
        Long id = list.stream().findFirst().get().getId();
        Article newArticle = new Article();
        newArticle.setTitle("haha");
        newArticle.setBody("melong");

        // when
        boolean result = articleService.updateArticle(id, newArticle);

        // then
        Assertions.assertThat(result).isTrue();
        Assertions.assertThat(articleService.getArticle(id).get().getId()).isEqualTo(id);
        Assertions.assertThat(articleService.getArticle(id).get().getTitle()).isEqualTo("haha");
        Assertions.assertThat(articleService.getArticle(id).get().getBody()).isEqualTo("melong");
    }

    @Test
    public void deleteArticle() {
        // given
        List<ArticleSimple> list = articleService.getArticleSimples(1);
        Long id = list.stream().findFirst().get().getId();

        // when
        boolean result = articleService.deleteArticle(id);

        // then
        Assertions.assertThat(result).isTrue();
        Assertions.assertThat(articleService.getArticle(id)).isNotPresent();
    }

}
