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

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie newMovie) {
        return movieService.addMovie(newMovie);
    }

    @PutMapping("/{imdbId}/members/{id}")
    public Movie addMemberToMovie( @PathVariable("imdbId") String imdbId,
                                   @PathVariable("id") long memberId) {
        return movieService.addMemberToMovie(imdbId, memberId);
    }

    @GetMapping("/{imdbId}/members")
    public List<Member> getAMembersMovies(@PathVariable("imdbId") String imdbId) {
        return movieService.getAllMembersOfAMovie(imdbId);
    }
}
