package myboard.spring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import myboard.spring.domain.HackerNewsBase;
import myboard.spring.repository.WebAPIRepository;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class HackerNewsItemServiceImpl implements HackerNewsItemService {

    private final WebAPIRepository repo;

    @Override
    public HackerNewsBase getItem(Long id) throws IOException {
        String requestPath = "item/" + id + ".json?print=pretty";
        String responseStr = repo.request(HttpMethod.GET, requestPath);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readerFor(HackerNewsBase.class).readValue(responseStr);
    }
}
