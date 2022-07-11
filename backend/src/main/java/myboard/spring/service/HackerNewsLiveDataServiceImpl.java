package myboard.spring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import myboard.spring.domain.StoryListType;
import myboard.spring.repository.WebAPIRepository;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HackerNewsLiveDataServiceImpl implements HackerNewsLiveDataService {

    private final WebAPIRepository repo;

    @Override
    public Long getMaxItemId() throws IOException {
        String requestPath = "maxitem.json?print=pretty";
        String responseStr = repo.request(HttpMethod.GET, requestPath);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readerFor(Long.class).readValue(responseStr);
    }

    @Override
    public List<Long> getStoryList(StoryListType type) throws IOException {
        String requestPath = getStoryReqPath(type);
        String responseStr = repo.request(HttpMethod.GET, requestPath);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readerFor(List.class).readValue(responseStr);
    }

    private String getStoryReqPath(StoryListType type) {
        String result;

        switch (type) {
            case TOP:
                result = "topstories.json?print=pretty";
                break;
            case NEW:
                result = "newstories.json?print=pretty";
                break;
            case BEST:
                result = "beststories.json?print=pretty";
                break;
            case ASK:
                result = "askstories.json?print=pretty";
                break;
            case SHOW:
                result = "showstories.json?print=pretty";
                break;
            case JOB:
                result = "jobstories.json?print=pretty";
                break;
            default:
                result = "";
                break;
        }

        return result;
    }

    @Override
    public HashMap<String, List<Object>> getUpdates() throws IOException {
        String requestPath = "updates.json?print=pretty";
        String responseStr = repo.request(HttpMethod.GET, requestPath);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readerFor(HashMap.class).readValue(responseStr);
    }

}
