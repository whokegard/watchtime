package com.example.watchtime.api;

import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import com.example.watchtime.model.TVShow;
import com.example.watchtime.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}/movies")
    public List<Movie> getAMembersMovies(@PathVariable("id") long memberId) {

        return memberService.getAMembersMovies(memberId);
    }

    @GetMapping("/{id}/tvshows")
    public List<TVShow> getAMembersTVShows(@PathVariable("id") long memberId) {

        return memberService.getAMembersTVShows(memberId);
    }

    /*@DeleteMapping("/{id}/movies/{imdbId}")
    public void removeMovie(@PathVariable("id") long memberId,
                            @PathVariable("imdbId") long imdbId) {
        memberService.removeMovie(memberId, imdbId);
    }*/

    @GetMapping("/{id}/watchedMovies")
    public List<Movie> getAMembersWatchedMovies(@PathVariable("id") long memberId) {
        return memberService.getAMembersWatchedMovies(memberId);
    }

    @GetMapping("/{id}/watchedTVShows")
    public List<TVShow> getAMembersWatchedTVShows(@PathVariable("id") long memberId) {
        return memberService.getAMembersWatchedTVShows(memberId);
    }

    @GetMapping("/{id}/notWatchedMovies")
    public List<Movie> getMembersNonWatchedMovies(@PathVariable("id") long memberId) {
        return memberService.getAMembersNonWatchedMovies(memberId);
    }

    @GetMapping("/{id}/notWatchedTVShows")
    public List<TVShow> getMembersNonWatchedTVShows(@PathVariable("id") long memberId) {
        return memberService.getMembersNonWatchedTVShows(memberId);
    }
}
