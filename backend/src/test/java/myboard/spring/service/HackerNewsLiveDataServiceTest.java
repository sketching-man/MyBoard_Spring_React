package myboard.spring.service;

import myboard.spring.domain.StoryListType;
import myboard.spring.repository.HackerNewsAPIRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class HackerNewsLiveDataServiceTest {

    HackerNewsAPIRepository repo = new HackerNewsAPIRepository();
    HackerNewsLiveDataService svc = new HackerNewsLiveDataServiceImpl(repo);

    @Test
    public void getMaxItemId() throws IOException {
        var result = svc.getMaxItemId();
        Assertions.assertThat(result).isInstanceOf(Long.class);
    }

    @Test
    public void getStoryList() throws IOException {
        var result = svc.getStoryList(StoryListType.TOP);
        Assertions.assertThat(result).isInstanceOf(List.class).hasSize(500);

        result = svc.getStoryList(StoryListType.NEW);
        Assertions.assertThat(result).isInstanceOf(List.class).hasSize(500);

        result = svc.getStoryList(StoryListType.BEST);
        Assertions.assertThat(result).isInstanceOf(List.class).hasSize(200);

        result = svc.getStoryList(StoryListType.ASK);
        Assertions.assertThat(result).isInstanceOf(List.class);

        result = svc.getStoryList(StoryListType.SHOW);
        Assertions.assertThat(result).isInstanceOf(List.class);

        result = svc.getStoryList(StoryListType.JOB);
        Assertions.assertThat(result).isInstanceOf(List.class);
    }

    @Test
    public void getUpdates() throws IOException {
        var result = svc.getUpdates();
        Assertions.assertThat(result).isInstanceOf(HashMap.class).hasSize(2);
    }

}
