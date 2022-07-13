package myboard.spring.service;

import myboard.spring.domain.HackerNewsBase;
import myboard.spring.repository.HackerNewsAPIRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class HackerNewsItemServiceTest {

    HackerNewsAPIRepository repo = new HackerNewsAPIRepository();
    HackerNewsItemService svc = new HackerNewsItemServiceImpl(repo);

    @Test
    public void getItem() throws IOException {
        var result = svc.getItem(8863L);
        Assertions.assertThat(result).isInstanceOf(HackerNewsBase.class);
    }

}
