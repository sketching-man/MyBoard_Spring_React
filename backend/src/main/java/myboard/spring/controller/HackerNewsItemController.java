package myboard.spring.controller;

import lombok.RequiredArgsConstructor;
import myboard.spring.domain.HackerNewsBase;
import myboard.spring.service.HackerNewsItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hackernews")
public class HackerNewsItemController {

    private final HackerNewsItemService svc;

    @GetMapping(value = "/item", params = "id")
    public HackerNewsBase getItem(@RequestParam Long id) {
        try {
            return svc.getItem(id);
        } catch (Exception e) {
            // do something!
            return null;
        }
    }

}
