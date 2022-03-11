package myboard.spring.controller;

import lombok.RequiredArgsConstructor;
import myboard.spring.domain.Article;
import myboard.spring.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping(params = "pageNo")
    public List<Article> findArticles(@RequestParam Integer pageNo,
                                      HttpServletResponse resp) {
        return null;
    }

    @PostMapping
    public Long addNewArticle(@RequestBody Article article,
                              HttpServletResponse resp) {
        return null;
    }

    @GetMapping(params = "id")
    public Article findArticle(@RequestParam Long id,
                               HttpServletResponse resp) {
        return null;
    }

    @PutMapping
    public void updateArticle(@RequestParam Long id,
                              @RequestBody Article article,
                              HttpServletResponse resp) {
    }

    @DeleteMapping
    public void deleteArticle(@RequestParam Long id,
                              HttpServletResponse resp) {
    }

}
