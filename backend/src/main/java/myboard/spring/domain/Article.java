package myboard.spring.domain;

import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Article {

    private Long id;
    private String title;
    private String body;
    private Member writer;
    private LocalDateTime writtenTime;

    public Article(String title, String body, Member writer, LocalDateTime writtenTime) {
        this.title = title;
        this.body = body;
        this.writer = writer;
        this.writtenTime = writtenTime;
    }

}
