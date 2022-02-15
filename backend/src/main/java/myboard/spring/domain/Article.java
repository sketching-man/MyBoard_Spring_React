package myboard.spring.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Article {

    @Id
    private Long id;

    @Column
    private String title;
    @Column
    private String body;
    @Column
    private Member writer;
    @Column
    private LocalDateTime writtenTime;

    public Article(String title, String body, Member writer, LocalDateTime writtenTime) {
        this.title = title;
        this.body = body;
        this.writer = writer;
        this.writtenTime = writtenTime;
    }

}
