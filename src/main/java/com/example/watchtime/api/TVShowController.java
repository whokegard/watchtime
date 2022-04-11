package com.example.watchtime.api;

import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import com.example.watchtime.model.TVShow;
import com.example.watchtime.service.MemberService;
import com.example.watchtime.service.TVShowService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tvshow")
public class TVShowController {

    @Autowired
    private final TVShowService tvShowService;

    @GetMapping
    public List<TVShow> getAllTVShows() {
        return tvShowService.getAllTVShows();
    }

    @PostMapping
    public TVShow addTVShow(@RequestBody TVShow newTVShow) {
        return tvShowService.addTVShow(newTVShow);
    }


    @PutMapping("/{imdbId}/members/{id}")
    public TVShow addMemberToTVShow( @PathVariable("imdbId") String imdbId,
                                   @PathVariable("id") long memberId) {
        return tvShowService.addMemberToTVShow(imdbId, memberId);
    }

    @GetMapping("/{imdbId}/members")
    public List<Member> getAMembersTVShows(@PathVariable("imdbId") String imdbId) {
        return tvShowService.getAllMembersOfATVShow(imdbId);
    }
}

