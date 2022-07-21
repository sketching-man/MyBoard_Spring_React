package myboard.spring.repository;

import lombok.RequiredArgsConstructor;
import myboard.spring.domain.Article;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaArticleRepository implements ArticleRepository {

    private final EntityManager em;

    @Override
    public Article save(Article article) {
        article.setWrittenTime(LocalDateTime.now());
        em.persist(article);
        return article;
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.ofNullable(em.find(Article.class, id));
    }

    @Override
    public List<Article> findAll() {
        return em.createQuery("SELECT a FROM Article a", Article.class)
                .getResultList();
    }

    @Override
    public List<Article> findByPage(Integer pageNo) {
        // TODO: 페이지 순서대로 20개씩 잘라서 보여줘야 함. 순서는 작성 시간 기준
        return em.createQuery("SELECT a FROM Article a", Article.class)
                .getResultList();
    }

    @Override
    public List<Article> findByTitle(String keyword) {
        // TODO: 순서대로 20개씩 잘라서 보여줘야 함. 순서는 작성 시간 기준
        String searchPattern = "%" + keyword + "%";
        return em.createQuery("SELECT a FROM Article a WHERE a.title LIKE :searchPattern", Article.class)
                .setParameter("searchPattern", searchPattern)
                .getResultList();
    }

    @Override
    public List<Article> findByBody(String keyword) {
        // TODO: 순서대로 20개씩 잘라서 보여줘야 함. 순서는 작성 시간 기준
        String searchPattern = "%" + keyword + "%";
        return em.createQuery("SELECT a FROM Article a WHERE a.body LIKE :searchPattern", Article.class)
                .setParameter("searchPattern", searchPattern)
                .getResultList();
    }

    @Override
    public List<Article> findByTitleOrBody(String keyword) {
        // TODO: 순서대로 20개씩 잘라서 보여줘야 함. 순서는 작성 시간 기준
        String searchPattern = "%" + keyword + "%";
        return em.createQuery("SELECT a FROM Article a WHERE a.body LIKE :searchPattern", Article.class)
                .setParameter("searchPattern", searchPattern)
                .getResultList();
    }

    @Override
    public List<Article> findByWriter(String writerName) {
        // TODO: 순서대로 20개씩 잘라서 보여줘야 함. 순서는 작성 시간 기준
        return em.createQuery("SELECT a FROM Article a INNER JOIN a.writer w WHERE w.userName = :writerName",
                        Article.class) // JPQL Inner Join!
                .setParameter("writerName", writerName)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(em::remove);
    }

}
