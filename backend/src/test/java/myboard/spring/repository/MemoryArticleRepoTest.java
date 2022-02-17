package myboard.spring.repository;

import myboard.spring.domain.Article;
import myboard.spring.domain.Grade;
import myboard.spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MemoryArticleRepoTest {

    ArticleRepository articleRepository = new MemoryArticleRepository();

    @AfterEach
    void afterEach() {
        if (articleRepository instanceof MemoryArticleRepository) {
            ((MemoryArticleRepository)articleRepository).clear();
        }
    }

    @Test
    public void save() {
        // given
        Member writer = new Member("jaemin", "asdf", Grade.User);
        Article article = new Article("hello", "my name is jaemin", writer, LocalDateTime.now());

        // when
        Article savedArticle = articleRepository.save(article);

        // then
        Optional<Article> foundArticle = articleRepository.findById(savedArticle.getId());
        Assertions.assertThat(foundArticle).isNotEmpty();
        Assertions.assertThat(foundArticle.get()).isEqualTo(savedArticle);
    }

    @Test
    public void findAll() {
        // given
        Member member1 = new Member("jaemin", "pw1", Grade.User);
        Member member2 = new Member("yoolmoo", "pw2", Grade.User);
        Member member3 = new Member("heedong", "pw3", Grade.Administrator);
        Article article1 = new Article("hello", "my name is jaemin", member1, LocalDateTime.now());
        Article article2 = new Article("hi", "my name is yoolmoo", member2, LocalDateTime.now());
        Article article3 = new Article("hi hello", "my name is heedong", member3, LocalDateTime.now());

        // when
        articleRepository.save(article1);
        articleRepository.save(article2);
        articleRepository.save(article3);

        // then
        List<Article> foundArticles = articleRepository.findAll();
        Assertions.assertThat(foundArticles).hasSize(3);
    }

    @Test
    public void findByPage() {
        // TBD
        // given

        // when

        // then
    }

    @Test
    public void findByTitle() {
        // given
        Member member1 = new Member("jaemin", "pw1", Grade.User);
        Member member2 = new Member("yoolmoo", "pw2", Grade.User);
        Member member3 = new Member("heedong", "pw3", Grade.Administrator);
        Article article1 = new Article("hello", "my name is jaemin", member1, LocalDateTime.now());
        Article article2 = new Article("hi", "my name is yoolmoo", member2, LocalDateTime.now());
        Article article3 = new Article("hi hello", "my name is heedong", member3, LocalDateTime.now());

        // when
        articleRepository.save(article1);
        articleRepository.save(article2);
        articleRepository.save(article3);

        // then
        List<Article> foundArticles = articleRepository.findByTitle("hello");
        Assertions.assertThat(foundArticles).hasSize(2);
        foundArticles = articleRepository.findByTitle("hi");
        Assertions.assertThat(foundArticles).hasSize(2);
    }

    @Test
    public void findByBody() {
        // given
        Member member1 = new Member("jaemin", "pw1", Grade.User);
        Member member2 = new Member("yoolmoo", "pw2", Grade.User);
        Member member3 = new Member("heedong", "pw3", Grade.Administrator);
        Article article1 = new Article("hello", "my name is jaemin", member1, LocalDateTime.now());
        Article article2 = new Article("hi", "my name is yoolmoo", member2, LocalDateTime.now());
        Article article3 = new Article("hi hello", "my name is heedong", member3, LocalDateTime.now());

        // when
        articleRepository.save(article1);
        articleRepository.save(article2);
        articleRepository.save(article3);

        // then
        List<Article> foundArticles = articleRepository.findByBody("hello");
        Assertions.assertThat(foundArticles).hasSize(0);
        foundArticles = articleRepository.findByBody("name");
        Assertions.assertThat(foundArticles).hasSize(3);
        foundArticles = articleRepository.findByBody("jaemin");
        Assertions.assertThat(foundArticles).hasSize(1);
    }

    @Test
    public void findByTitleOrBody() {
        // given
        Member member1 = new Member("jaemin", "pw1", Grade.User);
        Member member2 = new Member("yoolmoo", "pw2", Grade.User);
        Member member3 = new Member("heedong", "pw3", Grade.Administrator);
        Article article1 = new Article("hello", "my name is jaemin", member1, LocalDateTime.now());
        Article article2 = new Article("hi", "my name is yoolmoo", member2, LocalDateTime.now());
        Article article3 = new Article("hi hello", "my name is heedong", member3, LocalDateTime.now());

        // when
        articleRepository.save(article1);
        articleRepository.save(article2);
        articleRepository.save(article3);

        // then
        List<Article> foundArticles = articleRepository.findByTitleOrBody("hello");
        Assertions.assertThat(foundArticles).hasSize(2);
        foundArticles = articleRepository.findByTitleOrBody("name");
        Assertions.assertThat(foundArticles).hasSize(3);
        foundArticles = articleRepository.findByTitleOrBody("jaemin");
        Assertions.assertThat(foundArticles).hasSize(1);
    }

    @Test
    public void findByWriter() {
        // given
        Member member1 = new Member("jaemin", "pw1", Grade.User);
        Member member2 = new Member("yoolmoo", "pw2", Grade.User);
        Member member3 = new Member("heedong", "pw3", Grade.Administrator);
        Article article1 = new Article("hello", "my name is jaemin", member1, LocalDateTime.now());
        Article article2 = new Article("hi", "my name is yoolmoo", member2, LocalDateTime.now());
        Article article3 = new Article("hi hello", "my name is heedong", member3, LocalDateTime.now());

        // when
        articleRepository.save(article1);
        articleRepository.save(article2);
        articleRepository.save(article3);

        // then
        List<Article> foundArticles = articleRepository.findByWriter("jaemin");
        Assertions.assertThat(foundArticles).hasSize(1);
    }

}
