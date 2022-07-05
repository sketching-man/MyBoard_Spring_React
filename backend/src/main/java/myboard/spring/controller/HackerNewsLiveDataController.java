package myboard.spring.controller;

import lombok.RequiredArgsConstructor;
import myboard.spring.domain.StoryListType;
import myboard.spring.service.HackerNewsLiveDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hackernews")
public class HackerNewsLiveDataController {

    private final HackerNewsLiveDataService svc;

    @GetMapping("/maxitem")
    public Long getMaxItemId() {
        try {
            return svc.getMaxItemId();
        }
        catch (Exception e) {
            // do something!
            return -1L;
        }
    }

    @GetMapping("/topstories")
    public List<Long> getTopStories() {
        return svc.getStoryList(StoryListType.TOP);
    }

    @GetMapping("/newstories")
    public List<Long> getNewStories() {
        return svc.getStoryList(StoryListType.NEW);
    }

    @GetMapping("/beststories")
    public List<Long> getBestStories() {
        return svc.getStoryList(StoryListType.BEST);
    }

    @GetMapping("/askstories")
    public List<Long> getAskStories() {
        return svc.getStoryList(StoryListType.ASK);
    }

    @GetMapping("/showstories")
    public List<Long> getShowStories() {
        return svc.getStoryList(StoryListType.SHOW);
    }

    @GetMapping("/jobstories")
    public List<Long> getJobStories() {
        return svc.getStoryList(StoryListType.JOB);
    }

    @GetMapping("/updates")
    public List<Long> getUpdates() {
        return svc.getUpdates();
    }

}
