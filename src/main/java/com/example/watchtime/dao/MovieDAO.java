package com.example.watchtime.dao;

import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import com.example.watchtime.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class MovieDAO {

    private final MovieRepository movieRepository;

    public Movie save(Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    public Iterable<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public void deleteMovieFromAMembersList(long movieId) {
        movieRepository.deleteById(movieId);
    }

    public Optional<Movie> findMovieById(long movieId) {
        return movieRepository.findById(movieId);
    }
}
