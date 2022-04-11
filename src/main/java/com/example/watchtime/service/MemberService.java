package com.example.watchtime.service;

import com.example.watchtime.dao.MemberDAO;
import com.example.watchtime.dao.MovieDAO;
import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import com.example.watchtime.model.TVShow;
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

    public List<TVShow> getAMembersTVShows(long memberId) {
        return getMemberByID(memberId).getTvshow_list();
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

    public void removeMovie(long memberId, long movieId) {
        /*Optional<Movie> maybeMemberMovie = getAMembersMovies(memberId).stream()
                .filter(movie -> movie.getMovie_id() == (movieId))
                .findFirst();*/

        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);
        Optional<Movie> maybeMovie = movieDAO.findMovieById(movieId);

        if (maybeMovie.isEmpty() || maybeMember.isEmpty())
            return;

        Member member = maybeMember.get();
        Movie movie = maybeMovie.get();

        List<Movie> aMembersMovies = member.getMovie_list();
        System.out.println(movie.getTitle());
        aMembersMovies.remove(movie);

        List<Member> movieMembers = movie.getMember_list();
        System.out.println(member.getUsername());
        movieMembers.remove(member);

        member.setMovie_list(aMembersMovies);
        movie.setMember_list(movieMembers);

        memberDAO.saveMember(member);
        movieDAO.save(movie);
    }

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

    public List<TVShow> getAMembersWatchedTVShows(long memberId) {
        return getAMembersTVShows(memberId).stream()
                .filter(tvshow -> tvshow.getWatched() == 1)
                .collect(Collectors.toList());
    }

    public List<TVShow> getMembersNonWatchedTVShows(long memberId) {
        return getAMembersTVShows(memberId).stream()
                .filter(tvshow -> tvshow.getWatched() == 0)
                .collect(Collectors.toList());
    }
}
