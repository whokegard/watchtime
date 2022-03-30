package com.example.watchtime.service;

import com.example.watchtime.dao.RatingDAO;
import com.example.watchtime.model.Rating;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RatingService {

    private final RatingDAO ratingDAO;

    public void addRating(Rating newRating) {
        ratingDAO.saveRating(newRating);
    }
}
