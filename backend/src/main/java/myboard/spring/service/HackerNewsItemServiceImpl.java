package myboard.spring.service;

import lombok.RequiredArgsConstructor;
import myboard.spring.repository.WebAPIRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HackerNewsItemServiceImpl implements HackerNewsItemService {

    private final WebAPIRepository repo;

}
