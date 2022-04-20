package com.example.watchtime.api;

import com.example.watchtime.model.Movie;
import com.example.watchtime.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
@AllArgsConstructor
public class MovieController {

    @Autowired
    private final MovieService movieService;

    @PostMapping
    public Movie addMovie(@RequestBody Movie newMovie) {
        return movieService.addMovie(newMovie);
    }

    @PutMapping("/{movieId}/members/{id}")
    public Movie addMemberToMovie( @PathVariable("movieId") long movieId,
                                   @PathVariable("id") long memberId) {
        return movieService.addMemberToMovie(movieId, memberId);
    }
}
