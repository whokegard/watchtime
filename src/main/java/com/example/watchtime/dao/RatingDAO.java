package com.example.watchtime.dao;

import com.example.watchtime.model.Rating;
import com.example.watchtime.repository.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class RatingDAO {

    private final RatingRepository ratingRepository;

    public void saveRating(Rating rating) {
        ratingRepository.save(rating);
    }

}
