package com.example.watchtime.service;

import com.example.watchtime.dao.MovieDAO;
import com.example.watchtime.model.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieDAO movieDAO;

    //private final OMDBController omdbController;

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

    public List<Movie> getAllOfAMembersMovies(long watchlist_id) {
        return getAllMovies().stream()
                .filter(movie -> movie.getWatchlist_id() == watchlist_id)
                .collect(Collectors.toList());
    }

    public void removeMovieFromAMembersList(long movieId) {
        movieDAO.deleteMovieFromAMembersList(movieId);
    }

    public List<Movie> getMembersWatchedMovies(long watchlistId) {
        return getAllMovies().stream()
                .filter(movie -> movie.getWatchlist_id() == watchlistId)
                .filter(movie -> movie.getIsWatched() == 1)
                .collect(Collectors.toList());
    }

    public List<Movie> getMembersNonWatchedMovies(long watchlistId) {
        return getAllMovies().stream()
                .filter(movie -> movie.getWatchlist_id() == watchlistId)
                .filter(movie -> movie.getIsWatched() == 0)
                .collect(Collectors.toList());
    }

    /*public List<String> getAllMoviePostersOfAMember(long watchlistId) {
        List<Movie> allMovies = getAllOfAMembersMovies(watchlistId);
        List<String> posters = new ArrayList<>();
        for (Movie m : allMovies) {
            posters.add(omdbController.getPoster(m.getTitle(), m.getYear()));
        }

        return posters;
    }*/
}
