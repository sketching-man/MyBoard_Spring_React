package myboard.spring.repository;

import myboard.spring.domain.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemoryArticleRepository implements ArticleRepository {

    @Override
    public Article save(Article article) {
        return null;
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Article> findByTitle(String keyword) {
        return Optional.empty();
    }

    @Override
    public Optional<Article> findByBody(String keyword) {
        return Optional.empty();
    }

    @Override
    public Optional<Article> findByTitleOrBody(String keyword) {
        return Optional.empty();
    }

    @Override
    public Optional<Article> findByWriter(String writer) {
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

}
