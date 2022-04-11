package com.example.watchtime.api;

import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import com.example.watchtime.service.MemberService;
import com.example.watchtime.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/members/profile")
@AllArgsConstructor
public class ProfileController {

    @Autowired
    private final MovieService movieService;

    @Autowired
    private final MemberService memberService;

    /*@GetMapping("/{id}")
    public List<Movie> getAllOfAMembersMovies(
            @PathVariable("id") long id) {
        Member memberByID = memberService.getMemberByID(id);
        long watchlist_id = memberByID.getWatchlist_id();

        return movieService.getAllOfAMembersMoviesById(watchlist_id);
    }*/
}
