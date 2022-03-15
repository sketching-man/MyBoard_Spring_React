package myboard.spring.controller;

import lombok.RequiredArgsConstructor;
import myboard.spring.domain.Article;
import myboard.spring.domain.ArticleSimple;
import myboard.spring.domain.MemberSimple;
import myboard.spring.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping(params = "pageNo")
    public List<ArticleSimple> findArticles(@RequestParam Integer pageNo,
                                            HttpServletResponse resp) {
        List<ArticleSimple> foundArticles = articleService.getArticleSimples(pageNo);
        if (!foundArticles.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_OK);
            return foundArticles;
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return new ArrayList<>();
        }
    }

    @PostMapping
    public Long addNewArticle(@RequestBody Article article,
                              HttpServletResponse resp) {
        Long id = articleService.write(article);
        if (0L <= id) {
            resp.setStatus(HttpServletResponse.SC_CREATED);
            return id;
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return new Article().getId();
        }
    }

    @GetMapping(params = "id")
    public Article findArticle(@RequestParam Long id,
                               HttpServletResponse resp) {
        Optional<Article> foundArticle = articleService.getArticle(id);
        if (foundArticle.isPresent()) {
            resp.setStatus(HttpServletResponse.SC_OK);
            return foundArticle.get();
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return new Article();
        }
    }

    @PutMapping
    public void updateArticle(@RequestParam Long id,
                              @RequestBody Article article,
                              HttpServletResponse resp) {
        if (articleService.updateArticle(id, article))
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        else
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

    @DeleteMapping
    public void deleteArticle(@RequestParam Long id,
                              HttpServletResponse resp) {
        if (articleService.deleteArticle(id))
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        else
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

}
