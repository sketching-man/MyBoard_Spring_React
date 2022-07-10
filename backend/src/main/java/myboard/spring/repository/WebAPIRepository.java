package myboard.spring.repository;

import org.springframework.http.HttpMethod;

import java.io.IOException;

public interface WebAPIRepository {

    String request(HttpMethod method, String urlPath) throws IOException;

}
