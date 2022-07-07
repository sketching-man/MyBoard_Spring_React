package myboard.spring.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class HackerNewsStory extends HackerNewsBase {

    private Long descendants;
    private List<Long> kids;
    private Integer score;
    private String title;
    private String url;

}
