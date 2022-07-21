package myboard.spring.repository;

import myboard.spring.domain.Article;
import myboard.spring.domain.Grade;
import myboard.spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
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

    private Member testMember1;
    private Member testMember2;

    @BeforeEach
    public void beforeAll() {
        testMember1 = Member.builder()
                .userName("jaemin")
                .password("pw")
                .grade(Grade.Administrator)
                .build();
        memberRepository.save(testMember1);

        testMember2 = Member.builder()
                .userName("heedong")
                .password("pw")
                .grade(Grade.User)
                .build();
        memberRepository.save(testMember2);
    }

    @Test
    public void save() {
        // given
        Article article = Article.builder()
                .title("this is title")
                .body("this is body")
                .writer(testMember1)
                .build();

        // when
        var result = repo.save(article);

        // then
        Assertions.assertThat(result.getTitle()).isEqualTo("this is title");
    }

    @Test
    public void existsById() {
        // given
        Article article = Article.builder()
                .title("this is title")
                .body("this is body")
                .writer(testMember1)
                .build();
        var savedArticle = repo.save(article);

        // when
        var result = repo.existsById(savedArticle.getId());

        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void findById() {
        // given
        Article article = Article.builder()
                .title("this is title")
                .body("this is body")
                .writer(testMember1)
                .build();
        var savedArticle = repo.save(article);

        // when
        var result = repo.findById(savedArticle.getId());

        // then
        Assertions.assertThat(result).isPresent();
        Assertions.assertThat(result.get().getId()).isEqualTo(savedArticle.getId());
    }

    @Test
    public void findAll() {
        // given
        Article article1 = Article.builder()
                .title("this is title 1")
                .body("this is body 2")
                .writer(testMember1)
                .build();
        var savedArticle1 = repo.save(article1);

        Article article2 = Article.builder()
                .title("this is title 2")
                .body("this is body 3")
                .writer(testMember2)
                .build();
        var savedArticle2 = repo.save(article2);

        // when
        var result = repo.findAll();

        // then
        Assertions.assertThat(result).hasSize(2).contains(savedArticle1).contains(savedArticle2);
    }

    @Test
    public void findByPage() {
        // given
        Article article1 = Article.builder()
                .title("this is title 1")
                .body("this is body 2")
                .writer(testMember1)
                .build();
        var savedArticle1 = repo.save(article1);

        Article article2 = Article.builder()
                .title("this is title 2")
                .body("this is body 3")
                .writer(testMember2)
                .build();
        var savedArticle2 = repo.save(article2);

        // when
        var result = repo.findByPage(1);

        // then
        Assertions.assertThat(result).hasSize(2).contains(savedArticle1).contains(savedArticle2);
    }

    @Test
    public void findByTitle() {
        // given
        Article article1 = Article.builder()
                .title("this is title 1")
                .body("this is body 2")
                .writer(testMember1)
                .build();
        var savedArticle1 = repo.save(article1);

        Article article2 = Article.builder()
                .title("this is title 2")
                .body("this is body 3")
                .writer(testMember2)
                .build();
        var savedArticle2 = repo.save(article2);

        // when
        var result1 = repo.findByTitle("1");
        var result2 = repo.findByTitle("title");

        // then
        Assertions.assertThat(result1).hasSize(1).contains(savedArticle1);
        Assertions.assertThat(result2).hasSize(2).contains(savedArticle1).contains(savedArticle2);
    }

    @Test
    public void findByBody() {
        // given
        Article article1 = Article.builder()
                .title("this is title 1")
                .body("this is body 2")
                .writer(testMember1)
                .build();
        var savedArticle1 = repo.save(article1);

        Article article2 = Article.builder()
                .title("this is title 2")
                .body("this is body 3")
                .writer(testMember2)
                .build();
        var savedArticle2 = repo.save(article2);

        // when
        var result1 = repo.findByBody("3");
        var result2 = repo.findByBody("body");

        // then
        Assertions.assertThat(result1).hasSize(1).contains(savedArticle2);
        Assertions.assertThat(result2).hasSize(2).contains(savedArticle1).contains(savedArticle2);
    }

    @Test
    public void findByTitleOrBody() {
        // given
        Article article1 = Article.builder()
                .title("this is title 1")
                .body("this is body 2")
                .writer(testMember1)
                .build();
        var savedArticle1 = repo.save(article1);

        Article article2 = Article.builder()
                .title("this is title 2")
                .body("this is body 3")
                .writer(testMember2)
                .build();
        var savedArticle2 = repo.save(article2);

        // when
        var result1 = repo.findByTitleOrBody("1");
        var result2 = repo.findByTitleOrBody("2");

        // then
        Assertions.assertThat(result1).hasSize(1).contains(savedArticle1);
        Assertions.assertThat(result2).hasSize(2).contains(savedArticle1).contains(savedArticle2);
    }

    @Test
    public void findByWriter() {
        // given
        Article article1 = Article.builder()
                .title("this is title 1")
                .body("this is body 2")
                .writer(testMember1)
                .build();
        var savedArticle1 = repo.save(article1);

        Article article2 = Article.builder()
                .title("this is title 2")
                .body("this is body 3")
                .writer(testMember2)
                .build();
        var savedArticle2 = repo.save(article2);

        // when
        var result1 = repo.findByWriter(testMember1.getUserName());
        var result2 = repo.findByWriter(testMember2.getUserName());

        // then
        Assertions.assertThat(result1).hasSize(1).contains(savedArticle1);
        Assertions.assertThat(result2).hasSize(1).contains(savedArticle2);
    }

    @Test
    public void deleteById() {
        // given
        Article article1 = Article.builder()
                .title("this is title 1")
                .body("this is body 2")
                .writer(testMember1)
                .build();
        var savedArticle1 = repo.save(article1);

        Article article2 = Article.builder()
                .title("this is title 2")
                .body("this is body 3")
                .writer(testMember2)
                .build();
        var savedArticle2 = repo.save(article2);

        // when
        repo.deleteById(savedArticle1.getId());
        var result = repo.findAll();

        // then
        Assertions.assertThat(result).hasSize(1).contains(savedArticle2);
    }

}
