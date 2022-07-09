package myboard.spring.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class HackerNewsPoll extends HackerNewsBase {

    private Long descendants;
    private List<Long> kids;
    private List<Long> parts;
    private Integer score;
    private String text;
    private String title;

}
