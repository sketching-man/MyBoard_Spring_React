package myboard.spring.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = HackerNewsComment.class, name = "comment"),
        @JsonSubTypes.Type(value = HackerNewsJob.class, name = "job"),
        @JsonSubTypes.Type(value = HackerNewsPoll.class, name = "poll"),
        @JsonSubTypes.Type(value = HackerNewsPollopt.class, name = "pollopt"),
        @JsonSubTypes.Type(value = HackerNewsStory.class, name = "story")
})
public abstract class HackerNewsBase {

    private String by;
    private Long id;
    private Long time;
    private String type;

}