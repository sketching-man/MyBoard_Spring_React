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
        if (!memoryStore.containsKey(article.getId()))
            article.setId(++memoryIndex);
        memoryStore.put(article.getId(), article);
        return article;
    }

    @Override
    public boolean existsById(Long id) {
        return memoryStore.containsKey(id);
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
        // TODO: To be developed
        return findAll();
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

    @Override
    public void deleteById(Long id) {
        memoryStore.remove(id);
    }

    public void clear() {
        memoryStore.clear();
    }

}
