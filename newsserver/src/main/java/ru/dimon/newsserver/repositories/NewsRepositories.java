package ru.dimon.newsserver.repositories;

import org.springframework.stereotype.Repository;
import ru.dimon.newsserver.entities.News;

import java.util.List;

@Repository
public interface NewsRepositories {
    List<News> getAll();
}
