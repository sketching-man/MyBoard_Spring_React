package myboard.spring.repository;

import org.springframework.http.HttpMethod;

public interface WebAPIRepository {

    String request(HttpMethod method, String url);

}
