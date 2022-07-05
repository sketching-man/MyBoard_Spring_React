package myboard.spring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import myboard.spring.domain.StoryListType;

import java.util.List;

public interface HackerNewsLiveDataService {
    Long getMaxItemId() throws JsonProcessingException;

    List<Long> getStoryList(StoryListType type);

    List<Long> getUpdates();
}
