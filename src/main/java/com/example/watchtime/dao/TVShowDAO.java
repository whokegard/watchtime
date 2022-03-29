package com.example.watchtime.dao;

import com.example.watchtime.model.TVShow;
import com.example.watchtime.repository.TVShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class TVShowDAO {
    private final TVShowRepository tvShowRepository;

    public Optional<TVShow> findTVShowById(Long id) {
        return tvShowRepository.findById(id);
    }
}
