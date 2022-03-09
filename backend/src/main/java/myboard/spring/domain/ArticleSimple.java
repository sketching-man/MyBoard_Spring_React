package myboard.spring.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleSimple {

    private Long id;
    private String title;
    private Member writer;
    private LocalDateTime writtenTime;

    public ArticleSimple(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.writer = article.getWriter();
        this.writtenTime = article.getWrittenTime();
    }

}
