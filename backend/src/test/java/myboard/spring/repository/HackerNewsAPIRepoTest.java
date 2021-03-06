package myboard.spring.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import myboard.spring.domain.HackerNewsBase;
import myboard.spring.domain.HackerNewsStory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class HackerNewsAPIRepoTest {

    WebAPIRepository repo = new HackerNewsAPIRepository();

    @Test
    public void getJustNumber() throws IOException {
        String result = repo.request(HttpMethod.GET, "maxitem.json");

        Assertions.assertThat(result).containsOnlyDigits();
    }

    @Test
    public void getListData() throws IOException {
        String result = repo.request(HttpMethod.GET, "topstories.json");

        ObjectMapper mapper = new ObjectMapper();
        List<Long> parsed = mapper.readerFor(List.class).readValue(result);

        Assertions.assertThat(parsed).isInstanceOf(List.class).hasSize(500);
    }

    @Test
    public void getJsonDataAsDict() throws IOException {
        String result = repo.request(HttpMethod.GET, "updates.json");

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> parsed = mapper.readerFor(HashMap.class).readValue(result);

        Assertions.assertThat(parsed).isInstanceOf(HashMap.class);
    }

    @Test
    public void getJsonDataAsObject() throws IOException {
        String result = repo.request(HttpMethod.GET, "item/8863.json");

        ObjectMapper mapper = new ObjectMapper();
        HackerNewsStory parsed = mapper.readerFor(HackerNewsBase.class).readValue(result);

        Assertions.assertThat(parsed).isInstanceOf(HackerNewsBase.class);
    }

}
