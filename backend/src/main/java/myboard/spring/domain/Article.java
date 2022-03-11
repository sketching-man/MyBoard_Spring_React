package myboard.spring.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
//@Entity
public class Article {

    private static final Long defaultId = -1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column
    private String title;
//    @Column
    private String body;
//    @Column
    private Member writer;
//    @Column
    private LocalDateTime writtenTime;

    public Article() {
        this.id = defaultId;
        this.title = "";
        this.body = "";
        this.writer = new Member();
        this.writtenTime = LocalDateTime.now();
    }

    public Article(String title, String body, Member writer, LocalDateTime writtenTime) {
        this.id = defaultId;
        this.title = title;
        this.body = body;
        this.writer = writer;
        this.writtenTime = writtenTime;
    }

    public void update(Article article) {
        this.title = article.getTitle();
        this.body = article.getBody();
    }

}
