package myboard.spring.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class HackerNewsComment extends HackerNewsBase {

    private List<Long> kids;
    private Long parent;
    private String text;

}
