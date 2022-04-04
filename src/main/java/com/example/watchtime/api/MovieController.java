package com.example.watchtime.api;

import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import com.example.watchtime.service.MemberService;
import com.example.watchtime.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
@AllArgsConstructor
public class MovieController {

    @Autowired
    private final MovieService movieService;


    @PostMapping
    public void addMovie(@RequestBody Movie newMovie) {
        movieService.addMovie(newMovie);
    }

    @GetMapping("/{id}")
    public List<Movie> getAllOfAMembersMovies(
            @PathVariable("id") long watchlistId,
            @PathParam("title") String title
            ) {
        if (title != null)
            return movieService.getAMovieFromAMembersListByTitle(watchlistId, title);
        /*Member memberByID = memberService.getMemberByID(id);
        long watchlist_id = memberByID.getWatchlist_id();*/

        return movieService.getAllOfAMembersMovies(watchlistId);
    }

    @DeleteMapping("/{movieId}")
    public void removeMovieFromAMembersList(@PathVariable("movieId") long movieId) {
        movieService.removeMovieFromAMembersList(movieId);
    }

    /*@GetMapping("/{id}/posters")
    public List<String> allMoviePostersOfAMember(@PathVariable("id") long watchlistId) {
        return movieService.getAllMoviePostersOfAMember(watchlistId);
    }*/
}
