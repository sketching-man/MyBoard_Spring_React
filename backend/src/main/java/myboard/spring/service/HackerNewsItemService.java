package myboard.spring.service;

import myboard.spring.domain.HackerNewsBase;

import java.io.IOException;

public interface HackerNewsItemService {

    HackerNewsBase getItem(Long id) throws IOException;

}
