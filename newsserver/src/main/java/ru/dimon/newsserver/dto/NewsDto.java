package ru.dimon.newsserver.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewsDto {
    private LocalDateTime dateTime;
    private String title;
    private String newsText;
}
