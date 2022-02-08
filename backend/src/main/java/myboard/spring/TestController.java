package myboard.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {

    @GetMapping("/api/test")
    public String timeTeller() {
        return "Hello, current time is " + new Date() + ".";
    }

}
