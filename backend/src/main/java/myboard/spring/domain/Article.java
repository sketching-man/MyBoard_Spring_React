package myboard.spring.domain;

import lombok.Data;

@Data
public class Article {

    private Long id;
    private String title;
    private String body;
    private Member writer;

    public Article(String title, String body, Member writer) {
        this.title = title;
        this.body = body;
        this.writer = writer;
    }

}
