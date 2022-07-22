package myboard.spring.service;

import lombok.RequiredArgsConstructor;
import myboard.spring.domain.Article;
import myboard.spring.domain.ArticleSimple;
import myboard.spring.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final MemberService memberService;

    @Override
    public Long write(Article article) {
        if ((null == article.getWriter().getUserName() || article.getWriter().getUserName().isEmpty())
                && null != article.getWriter().getId()) {
            var writer = memberService.getMember(article.getWriter().getId());
            writer.ifPresent(article::setWriter);
        }
        return articleRepository.save(article).getId();
    }

    @Override
    public List<ArticleSimple> getArticleSimples(Integer pageNo) {
        List<Article> articleList = articleRepository.findByPage(pageNo);
        return articleList.stream().map(ArticleSimple::new).collect(Collectors.toList());
    }

    @Override
    public Optional<Article> getArticle(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public Boolean updateArticle(Long id, Article article) {
        if (articleRepository.existsById(id)) {
            article.setId(id);
            articleRepository.save(article);
            return true;
        }
        else
            return false;
    }

    @Override
    public Boolean deleteArticle(Long id) {
        if (articleRepository.existsById(id)) {
            articleRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

}
