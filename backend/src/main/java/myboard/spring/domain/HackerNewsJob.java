package myboard.spring.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@JsonTypeName("job")
public final class HackerNewsJob extends HackerNewsBase {

    private Integer score;
    private String text;
    private String title;
    private String url;

}
