package myboard.spring.repository;

import myboard.spring.domain.Article;
import myboard.spring.domain.Grade;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {

    Article save(Article article);
    Optional<Article> findById(Long id);
    Optional<Article> findByTitle(String keyword);
    Optional<Article> findByBody(String keyword);
    Optional<Article> findByTitleOrBody(String keyword);
    Optional<Article> findByWriter(String writer);
    List<Article> findAll();
    List<Article> findByPage(Integer pageNo);

}
