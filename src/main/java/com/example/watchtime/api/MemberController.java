package com.example.watchtime.api;

import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import com.example.watchtime.model.TVShow;
import com.example.watchtime.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{id}")
    public ResponseEntity updateMember(@PathVariable Long id, @RequestBody Member member) {
        Member currentMember = memberService.getMemberByID(id);
        currentMember.setUsername(member.getUsername());
        currentMember.setFirst_name(member.getFirst_name());
        currentMember.setLast_name(member.getLast_name());
        currentMember.setEmail(member.getEmail());
        currentMember.setPassword(member.getPassword());
        memberService.addMember(member);

        return ResponseEntity.ok(currentMember);
    }

    @GetMapping("/{id}/movies")
    public List<Movie> getAMembersMovies(@PathVariable("id") long memberId) {

        return memberService.getAMembersMovies(memberId);
    }

    @GetMapping("/{id}/tvshows")
    public List<TVShow> getAMembersTVShows(@PathVariable("id") long memberId) {

        return memberService.getAMembersTVShows(memberId);
    }

    @PutMapping("/{id}/movies/{movieId}")
    public void removeMovie(@PathVariable("id") long memberId,
                            @PathVariable("movieId") long movieId) {
        memberService.removeMovie(memberId, movieId);
    }

    @PutMapping("/{id}/tvShow/{tvShowId}")
    public void removeTVShow(@PathVariable("id") long memberId,
                            @PathVariable("tvShowId") long tvShowId) {
        memberService.removeTVShow(memberId, tvShowId);
    }

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
        return memberService.getAMembersNonWatchedTVShows(memberId);
    }

    @PutMapping("/{id}/movies/{movieId}/removeFromWatched")
    public List<Movie> removeMovieFromWatchedList(@PathVariable("id") long memberId, @PathVariable("movieId") long movieId) {
        return memberService.removeMovieFromWatchedList(memberId, movieId);
    }

    @PutMapping("/{id}/movies/{movieId}/addWatched")
    public List<Movie> addMovieToWatchedList(@PathVariable("id") long memberId, @PathVariable("movieId") long movieId) {
        return memberService.addMovieToWatchedList(memberId, movieId);
    }

    @PutMapping("/{id}/tvShow/{tvShowId}/removeFromWatched")
    public List<TVShow> removeTVShowFromWatchedList(@PathVariable("id") long memberId, @PathVariable("tvShowId") long tvShowId) {
        return memberService.removeTVShowFromWatchedList(memberId, tvShowId);
    }

    @PutMapping("/{id}/tvShow/{tvShowId}/addWatched")
    public List<TVShow> addTVShowToWatchedList(@PathVariable("id") long memberId, @PathVariable("tvShowId") long tvShowId) {
        return memberService.addTVShowToWatchedList(memberId, tvShowId);
    }
}
