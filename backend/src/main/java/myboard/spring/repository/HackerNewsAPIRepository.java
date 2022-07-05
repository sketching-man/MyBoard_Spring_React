package myboard.spring.repository;

import org.springframework.http.HttpMethod;

public class HackerNewsAPIRepository implements WebAPIRepository {

    @Override
    public String request(HttpMethod method, String url) {
        return "";
    }

}
