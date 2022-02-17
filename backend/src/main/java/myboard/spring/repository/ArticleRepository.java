package myboard.spring.repository;

import myboard.spring.domain.Article;
import myboard.spring.domain.Grade;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {

    Article save(Article article);
    Optional<Article> findById(Long id);
    List<Article> findAll();
    List<Article> findByPage(Integer pageNo);
    List<Article> findByTitle(String keyword);
    List<Article> findByBody(String keyword);
    List<Article> findByTitleOrBody(String keyword);
    List<Article> findByWriter(String writerName);

}
