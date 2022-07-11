package myboard.spring.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@JsonTypeName("") //?
public final class HackerNewsAsk extends HackerNewsBase {

    private Long descendants;
    private List<Long> kids;
    private Integer score;
    private String text;
    private String title;

}
