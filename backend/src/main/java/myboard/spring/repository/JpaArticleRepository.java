package myboard.spring.repository;

import lombok.RequiredArgsConstructor;
import myboard.spring.domain.Article;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaArticleRepository implements ArticleRepository {

    private final EntityManager em;

    @Override
    public Article save(Article article) {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    public List<Article> findByPage(Integer pageNo) {
        return null;
    }

    @Override
    public List<Article> findByTitle(String keyword) {
        return null;
    }

    @Override
    public List<Article> findByBody(String keyword) {
        return null;
    }

    @Override
    public List<Article> findByTitleOrBody(String keyword) {
        return null;
    }

    @Override
    public List<Article> findByWriter(String writerName) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

}
