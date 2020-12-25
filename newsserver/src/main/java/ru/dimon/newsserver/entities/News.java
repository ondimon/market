package ru.dimon.newsserver.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class News {
    private LocalDateTime dateTime;
    private String title;
    private String newsText;
}
