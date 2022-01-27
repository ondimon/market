package ru.dimon.newsserver.repositories;

import org.springframework.stereotype.Repository;

import ru.dimon.newsserver.entities.News;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class NewRepositoriesInMem implements NewsRepositories{
    private final List<News> newsList = new ArrayList<>();

    @PostConstruct
    public void init() {
      newsList.add(new News(LocalDateTime.now(), "news 1","bla-bla-bla"));
      newsList.add(new News(LocalDateTime.now(), "news 2","bla-bla-bla"));
      newsList.add(new News(LocalDateTime.now(), "news 3","bla-bla-bla"));
      newsList.add(new News(LocalDateTime.now(), "news 4","bla-bla-bla"));
      newsList.add(new News(LocalDateTime.now(), "news 5","bla-bla-bla"));
      newsList.add(new News(LocalDateTime.now(), "news 6","bla-bla-bla"));
    }

    @Override
    public List<News> getAll() {
        return Collections.unmodifiableList(newsList);
    }
}
