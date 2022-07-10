package myboard.spring.controller;

import lombok.RequiredArgsConstructor;
import myboard.spring.domain.StoryListType;
import myboard.spring.service.HackerNewsLiveDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
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
        } catch (Exception e) {
            // do something!
            return -1L;
        }
    }

    @GetMapping("/topstories")
    public List<Long> getTopStories() {
        try {
            return svc.getStoryList(StoryListType.TOP);
        } catch (Exception e) {
            // do something!
            return new ArrayList<>();
        }
    }

    @GetMapping("/newstories")
    public List<Long> getNewStories() {
        try{
        return svc.getStoryList(StoryListType.NEW);
        } catch (Exception e) {
            // do something!
            return new ArrayList<>();
        }
    }

    @GetMapping("/beststories")
    public List<Long> getBestStories() {
        try{
        return svc.getStoryList(StoryListType.BEST);
        } catch (Exception e) {
            // do something!
            return new ArrayList<>();
        }
    }

    @GetMapping("/askstories")
    public List<Long> getAskStories() {
        try{
        return svc.getStoryList(StoryListType.ASK);
        } catch (Exception e) {
            // do something!
            return new ArrayList<>();
        }
    }

    @GetMapping("/showstories")
    public List<Long> getShowStories() {
        try{
        return svc.getStoryList(StoryListType.SHOW);
        } catch (Exception e) {
            // do something!
            return new ArrayList<>();
        }
    }

    @GetMapping("/jobstories")
    public List<Long> getJobStories() {
        try{
        return svc.getStoryList(StoryListType.JOB);
        } catch (Exception e) {
            // do something!
            return new ArrayList<>();
        }
    }

    @GetMapping("/updates")
    public HashMap<String, List<Object>> getUpdates() {
        try{
        return svc.getUpdates();
        } catch (Exception e) {
            // do something!
            return new HashMap<>();
        }
    }

}
