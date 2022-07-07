package myboard.spring.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HackerNewsBase {

    private String by;
    private Long id;
    private Long time;
    private String type;

}
