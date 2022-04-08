package com.example.watchtime.service;

import com.example.watchtime.dao.MemberDAO;
import com.example.watchtime.dao.MovieDAO;
import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberDAO memberDAO;
    private final MovieDAO movieDAO;
    private final TVShowService tvShowDAO;

    public void addMember(Member newMember) {
        memberDAO.saveMember(newMember);
    }

    public List<Member> getAllMembers() {
        return (List<Member>) memberDAO.getAllMembers();
    }

    public Member getMemberByID(long id) {
        return memberDAO.findMemberByID(id).orElse(null);
    }

    public void deleteMemberById(long id) {
        Member member = getMemberByID(id);
        if (member == null)
            return;

        memberDAO.deleteMemberById(id);
    }

    public Member getMemberByUsernameAndPass(String username, String password) {
        Optional<Member> potentialMember = getAllMembers().stream()
                .filter(member -> member.getUsername().equalsIgnoreCase(username))
                .filter(m -> m.getPassword().equals(password))
                .findFirst();

        return potentialMember.orElse(null);
    }

    public List<Movie> getAMembersMovies(long memberId) {
        return getMemberByID(memberId).getMovie_list();
    }


   /* public List<Movie> getMoviesById(long watchlist_id) {
        return getAllMovies().stream()
                .filter(picture -> picture.getWatchlist_id() == watchlist_id)
                .collect(Collectors.toList());
    }*/

    /*public List<Movie> getAMembersMovies(long memberId) {
        return getMemberByID(memberId).getMovie_list();
                .filter(movie -> movie.getWatchlist_id() == watchlist_id)
                .collect(Collectors.toList());
    }*/

    /*public void removeMovie(long memberId, long imdbId) {
        movieDAO.deleteMovieFromAMembersList(memberId, imdbId);
    }*/

    public List<Movie> getAMembersWatchedMovies(long memberId) {
        return getAMembersMovies(memberId).stream()
                .filter(movie -> movie.getWatched() == 1)
                .collect(Collectors.toList());
    }

    public List<Movie> getAMembersNonWatchedMovies(long memberId) {
        return getAMembersMovies(memberId).stream()
                .filter(movie -> movie.getWatched() == 0)
                .collect(Collectors.toList());
    }

}
