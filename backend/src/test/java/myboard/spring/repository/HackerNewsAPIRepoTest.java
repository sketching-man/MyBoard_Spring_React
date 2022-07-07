package myboard.spring.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import java.io.IOException;

public class HackerNewsAPIRepoTest {

    HackerNewsAPIRepository repo = new HackerNewsAPIRepository();

    @Test
    public void getJustNumber() throws IOException {
        String result = repo.request(HttpMethod.GET, "maxitem.json");

        Assertions.assertThat(result).containsOnlyDigits();
    }

    @Test
    public void getJsonData() {
        String result = repo.request(HttpMethod.GET, "")
    }

}
