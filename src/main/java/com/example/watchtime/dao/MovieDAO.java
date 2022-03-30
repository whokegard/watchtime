package com.example.watchtime.dao;

import com.example.watchtime.model.Movie;
import com.example.watchtime.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
@AllArgsConstructor
public class MovieDAO {

    private final MovieRepository movieRepository;

    public void save(Movie newMovie) {
        movieRepository.save(newMovie);
    }

    @GetMapping
    public Iterable<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public void deleteMovieFromAMembersList(long movieId) {
        movieRepository.deleteById(movieId);
    }
}
