package myboard.spring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import myboard.spring.domain.StoryListType;
import myboard.spring.repository.WebAPIRepository;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HackerNewsLiveDataServiceImpl implements HackerNewsLiveDataService {

    private final WebAPIRepository repo;

    @Override
    public Long getMaxItemId() throws IOException {
        String requestPath = "maxitem.json?print=pretty";
        var result = repo.request(HttpMethod.GET, requestPath);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(result, Long.class);
    }

    @Override
    public List<Long> getStoryList(StoryListType type) {
        return null;
    }

    @Override
    public List<Long> getUpdates() {
        return null;
    }

}
