package myboard.spring.controller;

import lombok.RequiredArgsConstructor;
import myboard.spring.service.HackerNewsItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hackernews")
public class HackerNewsItemController {

    private final HackerNewsItemService svc;

    @GetMapping(value = "/item", params = "id")
    public Object getItem(@RequestParam Long id) {
        return null;
    }

}
