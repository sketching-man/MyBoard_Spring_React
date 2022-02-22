package myboard.spring.service;

import lombok.RequiredArgsConstructor;
import myboard.spring.repository.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

}
