package com.example.watchtime.service;

import com.example.watchtime.dao.MovieDAO;
import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieDAO movieDAO;

    public void addMovie(Movie newMovie) {
        movieDAO.save(newMovie);
    }

    public List<Movie> getAllMovies() {
        return (List<Movie>) movieDAO.findAllMovies();
    }

    public List<Movie> getAllOfAMembersMoviesById(long watchlist_id) {
        return getAllMovies().stream()
                .filter(picture -> picture.getWatchlist_id() == watchlist_id)
                .collect(Collectors.toList());
    }

    public List<Movie> getAllMoviesByType(long watchlist_id, String type) {
        return getAllMovies().stream()
                .filter(picture -> picture.getWatchlist_id() == watchlist_id)
                .filter(picture -> picture.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    public List<Movie> getAllOfAMembersMovies(long watchlist_id) {
        return getAllMovies().stream()
                .filter(movie -> movie.getWatchlist_id() == watchlist_id)
                .collect(Collectors.toList());
    }

    public void removeMovieFromAMembersList(long movieId) {
        movieDAO.deleteMovieFromAMembersList(movieId);
    }

    public List<Movie> getAMovieFromAMembersListByTitle(long watchlistId, String title) {
        return getAllMovies().stream()
                .filter(movie -> movie.getWatchlist_id() == watchlistId).
                filter(movie -> movie.getTitle().equalsIgnoreCase(title)).
                collect(Collectors.toList());
    }
}