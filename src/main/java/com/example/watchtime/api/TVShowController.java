package com.example.watchtime.api;

import com.example.watchtime.model.TVShow;
import com.example.watchtime.service.TVShowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TVShowController {
    TVShowService tvShowService;

    public TVShowController(TVShowService tvShowService) {
        this.tvShowService = tvShowService;
    }

    @GetMapping("/tvshow/{id}")
    public TVShow getTVShowById(@PathVariable("id") Integer id) {
        return tvShowService.getTVShowById(id);
    }
}
