package com.example.watchtime.api;

import com.example.watchtime.model.Rating;
import com.example.watchtime.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RatingController {

    @Autowired
    private final RatingService ratingService;

    @PostMapping("/rating")
    public void addRating(@RequestBody Rating rating) {
        ratingService.addRating(rating);
    }
}