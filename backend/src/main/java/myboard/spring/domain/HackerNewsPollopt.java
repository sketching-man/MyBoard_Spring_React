package myboard.spring.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@JsonTypeName("pollopt")
public final class HackerNewsPollopt extends HackerNewsBase {

    private Long poll;
    private Integer score;
    private String text;

}
