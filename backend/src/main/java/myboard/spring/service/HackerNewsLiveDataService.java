package myboard.spring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import myboard.spring.domain.StoryListType;

import java.io.IOException;
import java.util.List;

public interface HackerNewsLiveDataService {
    Long getMaxItemId() throws IOException;

    List<Long> getStoryList(StoryListType type);

    List<Long> getUpdates();
}
