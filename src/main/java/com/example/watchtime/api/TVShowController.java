package com.example.watchtime.api;

import com.example.watchtime.model.TVShow;
import com.example.watchtime.service.TVShowService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tvshow")
public class TVShowController {

    @Autowired
    private final TVShowService tvShowService;

    @GetMapping("/tvshow/{id}")
    public TVShow getTVShowById(@PathVariable("id") Long id) {
        return tvShowService.getTVShowById(id);
    }
}
