package myboard.spring.service;

import myboard.spring.domain.StoryListType;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface HackerNewsLiveDataService {

    Long getMaxItemId() throws IOException;

    List<Long> getStoryList(StoryListType type) throws IOException;

    HashMap<String, List<Object>> getUpdates() throws IOException;

}
