package myboard.spring.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class HackerNewsPollopt extends HackerNewsBase {

    private Long poll;
    private Integer score;
    private String text;

}
