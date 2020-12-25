package ru.dimon.newsserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.dimon.newsserver.dto.NewsDto;
import ru.dimon.newsserver.entities.News;

import java.util.List;

@Mapper
public interface NewsMapper {
    NewsMapper MAPPER = Mappers.getMapper(NewsMapper.class);

    NewsDto fromNews(News news);
    List<NewsDto> listFromNews(List<News> list);
}
