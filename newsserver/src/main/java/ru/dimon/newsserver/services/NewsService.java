package ru.dimon.newsserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dimon.newsserver.dto.NewsDto;
import ru.dimon.newsserver.entities.News;
import ru.dimon.newsserver.mappers.NewsMapper;
import ru.dimon.newsserver.repositories.NewsRepositories;

import java.util.List;
import java.util.Random;

@Service
public class NewsService {
    private final NewsRepositories newsRepositories;
    private final NewsMapper newsMapper = NewsMapper.MAPPER;

    @Autowired
    public NewsService(NewsRepositories newsRepositories) {
        this.newsRepositories = newsRepositories;
    }

    public List<NewsDto> getAll() {
        return newsMapper.listFromNews(newsRepositories.getAll());
    }
    public NewsDto getRandomNews(){
        List<News> newsList = newsRepositories.getAll();
        Random random = new Random();
        int index = random.nextInt(newsList.size());
        return newsMapper.fromNews(newsList.get(index));
    }
}
