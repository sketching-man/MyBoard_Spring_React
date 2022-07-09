package myboard.spring.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class HackerNewsJob extends HackerNewsBase {

    private Integer score;
    private String text;
    private String title;
    private String url;

}
