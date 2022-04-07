package com.example.watchtime.api;

import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import com.example.watchtime.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/members")
@AllArgsConstructor
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @PostMapping
    public void addMember(@RequestBody Member newMember) {
        memberService.addMember(newMember);
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable("id") long id) {
        return memberService.getMemberByID(id);
    }

    @GetMapping("/{username}/{password}")
    public Member getMemberByUsernameAndPass(
            @PathVariable("username") String username, @PathVariable String password) {
        return memberService.getMemberByUsernameAndPass(username, password);
    }

    @DeleteMapping("/{id}")
    public void deleteMemberById(@PathVariable("id") long id) {
        memberService.deleteMemberById(id);
    }

    /*@GetMapping("/{id}")
    public List<Movie> getAMembersMovies(@PathVariable("id") long memberId) {

        return memberService.getAMembersMovies(memberId);
    }

    @DeleteMapping("/{id}/movies/{imdbId}")
    public void removeMovie(@PathVariable("id") long memberId,
                            @PathVariable("imdbId") long imdbId) {
        memberService.removeMovie(memberId, imdbId);
    }

    @GetMapping("/{id}/watched")
    public List<Movie> getWatchedMovies(@PathVariable("id") long watchlistId) {
        return memberService.getWatchedMovies(watchlistId);
    }

    @GetMapping("/{id}/notWatched")
    public List<Movie> getNonWatchedMovies(@PathVariable("id") long watchlistId) {
        return memberService.getNonWatchedMovies(watchlistId);
    }*/
}
