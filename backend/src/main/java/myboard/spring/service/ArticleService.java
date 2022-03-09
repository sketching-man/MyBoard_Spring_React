package myboard.spring.service;

import myboard.spring.domain.Article;
import myboard.spring.domain.ArticleSimple;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    Long write(Article article);
    List<ArticleSimple> getArticleSimples(Integer pageNo);
    Optional<Article> getArticle(Long id);
    Boolean updateArticle(Long id, Article article);
    Boolean deleteArticle(Long id);

}
