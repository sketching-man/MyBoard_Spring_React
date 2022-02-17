package myboard.spring.repository;

import myboard.spring.domain.Article;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MemoryArticleRepository implements ArticleRepository {

    private static final Map<Long, Article> memoryStore = new HashMap<>();
    private static Long memoryIndex = 0L;

    @Override
    public Article save(Article article) {
        article.setId(++memoryIndex);
        memoryStore.put(article.getId(), article);
        return article;
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.ofNullable(memoryStore.get(id));
    }

    @Override
    public List<Article> findAll() {
        return new ArrayList<>(memoryStore.values());
    }

    @Override
    public List<Article> findByPage(Integer pageNo) {
        return null;
    }

    @Override
    public List<Article> findByTitle(String keyword) {
        return memoryStore.values().stream()
                .filter(article -> article.getTitle().contains(keyword))
                .collect(Collectors.toList());
    }

    @Override
    public List<Article> findByBody(String keyword) {
        return memoryStore.values().stream()
                .filter(article -> article.getBody().contains(keyword))
                .collect(Collectors.toList());
    }

    @Override
    public List<Article> findByTitleOrBody(String keyword) {
        return memoryStore.values().stream()
                .filter(article -> article.getTitle().contains(keyword) || article.getBody().contains(keyword))
                .collect(Collectors.toList());
    }

    @Override
    public List<Article> findByWriter(String writerName) {
        return memoryStore.values().stream()
                .filter(article -> article.getWriter().getUserName().equals(writerName))
                .collect(Collectors.toList());
    }

    public void clear() {
        memoryStore.clear();
    }

}
