package myboard.spring.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@JsonTypeName("comment")
public final class HackerNewsComment extends HackerNewsBase {

    private List<Long> kids;
    private Long parent;
    private String text;

}
