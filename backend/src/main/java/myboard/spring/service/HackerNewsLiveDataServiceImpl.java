package myboard.spring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import myboard.spring.domain.StoryListType;
import myboard.spring.repository.WebAPIRepository;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HackerNewsLiveDataServiceImpl implements HackerNewsLiveDataService {

    private final WebAPIRepository repo;

    private static final String baseUrl = "https://hacker-news.firebaseio.com/v0/";

    @Override
    public Long getMaxItemId() throws JsonProcessingException {
        String requestUrl = baseUrl + "maxitem.json?print=pretty";
        var result = repo.request(HttpMethod.GET, requestUrl);

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
