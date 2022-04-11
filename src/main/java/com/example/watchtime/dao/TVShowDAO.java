package com.example.watchtime.dao;

import com.example.watchtime.model.Movie;
import com.example.watchtime.model.TVShow;
import com.example.watchtime.repository.TVShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class TVShowDAO {
    private final TVShowRepository tvShowRepository;

    public TVShow save(TVShow newTVShow) {
        return tvShowRepository.save(newTVShow);
    }

    public Iterable<TVShow> findAllTVShows() {
        return tvShowRepository.findAll();
    }

    public void deleteMovieFromAMembersList(long tvshowId) {
        tvShowRepository.deleteById(tvshowId);
    }

    public Optional<TVShow> findTVShowById(long tvshowId) {
        return tvShowRepository.findById(tvshowId);
    }
}
