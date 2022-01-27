package ru.dimon.newsserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.dimon.newsserver.dto.NewsDto;
import ru.dimon.newsserver.services.NewsService;

import java.util.List;

@RestController
public class MainController {
    private NewsService newsService;

    @Autowired
    public MainController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping({"","/"})
    public List<NewsDto> index(){
        return newsService.getAll();
    }

    @GetMapping("/random")
    public NewsDto getRandom(){
        return newsService.getRandomNews();
    }

}
