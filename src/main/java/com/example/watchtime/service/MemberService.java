package com.example.watchtime.service;

import com.example.watchtime.dao.MemberDAO;
import com.example.watchtime.dao.MovieDAO;
import com.example.watchtime.dao.TVShowDAO;
import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import com.example.watchtime.model.TVShow;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberDAO memberDAO;
    private final MovieDAO movieDAO;
    private final TVShowDAO tvShowDAO;

    public Member addMember(Member newMember) {
        return memberDAO.saveMember(newMember);
    }

    public List<Member> getAllMembers() {
        return (List<Member>) memberDAO.getAllMembers();
    }

    public Member getMemberByID(long id) {
        return memberDAO.findMemberByID(id).orElse(null);
    }

    public void deleteMemberById(long id) {
        Optional<Member> maybeMember = memberDAO.findMemberByID(id);
        if (maybeMember.isEmpty())
            return;
        Member member = maybeMember.get();

        List<TVShow> unwatchedTVShows = member.getUnwatched_tvshows();
        for (int i = 0; i < unwatchedTVShows.size(); i++) {
            removeTVShow(member.getMember_id(), unwatchedTVShows.get(i).getTvshow_id());
        }

        List<TVShow> watchedTVShows = member.getWatched_tvshows();
        for (int i = 0; i < watchedTVShows.size(); i++) {
            removeTVShow(member.getMember_id(), watchedTVShows.get(i).getTvshow_id());
        }

        List<Movie> unwatchedMovies = member.getUnwatched_movies();
        for (int i = 0; i < unwatchedMovies.size(); i++) {
            removeMovie(member.getMember_id(), unwatchedMovies.get(i).getMovie_id());
        }

        List<Movie> watchedMovies = member.getWatched_movies();
        for (int i = 0; i < watchedMovies.size(); i++) {
            removeMovie(member.getMember_id(), watchedMovies.get(i).getMovie_id());
        }
        memberDAO.deleteMemberById(member.getMember_id());
    }

    public Member getMemberByUsernameAndPass(String username, String password) {
        Optional<Member> potentialMember = getAllMembers().stream()
                .filter(member -> member.getUsername().equalsIgnoreCase(username))
                .filter(m -> m.getPassword().equals(password))
                .findFirst();

        return potentialMember.orElse(null);
    }

    public List<Movie> getAMembersMovies(long memberId) {
        List<Movie> allOfAMembersMovies = new ArrayList<>();
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);

        if (maybeMember.isEmpty())
            return null;

        Member member = maybeMember.get();


        allOfAMembersMovies.addAll(member.getUnwatched_movies());
        allOfAMembersMovies.addAll(member.getWatched_movies());

        return allOfAMembersMovies;
    }

    public List<TVShow> getAMembersTVShows(long memberId) {
        List<TVShow> allOfAMembersTVShows = new ArrayList<>();
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);

        if (maybeMember.isEmpty())
            return null;

        Member member = maybeMember.get();

        allOfAMembersTVShows.addAll(member.getUnwatched_tvshows());
        allOfAMembersTVShows.addAll(member.getWatched_tvshows());

        return allOfAMembersTVShows;
    }

    public void removeMovie(long memberId, long movieId) {
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);
        Optional<Movie> maybeMovie = movieDAO.findMovieById(movieId);

        if (maybeMovie.isEmpty() || maybeMember.isEmpty())
            return;

        Member member = maybeMember.get();
        Movie movie = maybeMovie.get();

        List<Movie> aMembersUnwatchedMovies = member.getUnwatched_movies();
        aMembersUnwatchedMovies.remove(movie);

        List<Movie> aMembersWatchedMovies = member.getWatched_movies();
        aMembersWatchedMovies.remove(movie);

        List<Member> movieMembers = movie.getMember_list();
        movieMembers.remove(member);

        List<Member> watchedMembers = movie.getWatched();
        watchedMembers.remove(member);

        member.setUnwatched_movies(aMembersUnwatchedMovies);
        member.setWatched_movies(aMembersWatchedMovies);
        movie.setMember_list(movieMembers);
        movie.setWatched(watchedMembers);

        memberDAO.saveMember(member);
        movieDAO.save(movie);
    }

    public void removeTVShow(long memberId, long tvShowId) {
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);
        Optional<TVShow> maybeTVShow = tvShowDAO.findTVShowById(tvShowId);

        if (maybeTVShow.isEmpty() || maybeMember.isEmpty())
            return;

        Member member = maybeMember.get();
        TVShow tvShow = maybeTVShow.get();

        List<TVShow> aMembersUnwatchedTVShows = member.getUnwatched_tvshows();
        aMembersUnwatchedTVShows.remove(tvShow);

        List<TVShow> aMembersWatchedTVShows = member.getWatched_tvshows();
        aMembersWatchedTVShows.remove(tvShow);

        List<Member> tvShowMembers = tvShow.getMember_list();
        tvShowMembers.remove(member);

        List<Member> watchedMembers = tvShow.getWatched();
        watchedMembers.remove(member);

        member.setUnwatched_tvshows(aMembersUnwatchedTVShows);
        member.setWatched_tvshows(aMembersWatchedTVShows);
        tvShow.setMember_list(tvShowMembers);
        tvShow.setWatched(watchedMembers);

        memberDAO.saveMember(member);
        tvShowDAO.save(tvShow);
    }



    public List<Movie> getAMembersWatchedMovies(long memberId) {
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);

        if (maybeMember.isEmpty())
            return null;

        Member member = maybeMember.get();

        return member.getWatched_movies();
    }

    public List<Movie> getAMembersNonWatchedMovies(long memberId) {
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);

        if (maybeMember.isEmpty())
            return null;

        Member member = maybeMember.get();

        return member.getUnwatched_movies();
    }

    public List<TVShow> getAMembersWatchedTVShows(long memberId) {
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);

        if (maybeMember.isEmpty())
            return null;

        Member member = maybeMember.get();

        return member.getWatched_tvshows();
    }

    public List<TVShow> getAMembersNonWatchedTVShows(long memberId) {
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);

        if (maybeMember.isEmpty())
            return null;

        Member member = maybeMember.get();

        return member.getUnwatched_tvshows();
    }

    public List<Movie> addMovieToWatchedList(long memberId, long movieId) {
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);
        Optional<Movie> maybeMovie = movieDAO.findMovieById(movieId);

        if (maybeMember.isEmpty() || maybeMovie.isEmpty()) {
            return null;
        }

        Member member = maybeMember.get();
        Movie movie = maybeMovie.get();

        List<Movie> watchedMovies = member.getWatched_movies();
        watchedMovies.add(movie);

        List<Member> watched = movie.getWatched();
        watched.add(member);

        member.getUnwatched_movies().remove(movie);

        movieDAO.save(movie);
        memberDAO.saveMember(member);

        return member.getWatched_movies();
    }

    public List<Movie> removeMovieFromWatchedList(long memberId, long movieId) {
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);
        Optional<Movie> maybeMovie = movieDAO.findMovieById(movieId);

        if (maybeMember.isEmpty() || maybeMovie.isEmpty()) {
            return null;
        }

        Member member = maybeMember.get();
        Movie movie = maybeMovie.get();

        List<Movie> watchedMovies = member.getWatched_movies();
        watchedMovies.remove(movie);

        List<Member> watched = movie.getWatched();
        watched.remove(member);

        List<Movie> unwatchedMovies = member.getUnwatched_movies();
        unwatchedMovies.add(movie);

        movieDAO.save(movie);
        memberDAO.saveMember(member);

        return member.getWatched_movies();
    }

    public List<TVShow> addTVShowToWatchedList(long memberId, long tvShowId) {
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);
        Optional<TVShow> maybeTVShow = tvShowDAO.findTVShowById(tvShowId);

        if (maybeMember.isEmpty() || maybeTVShow.isEmpty()) {
            return null;
        }

        Member member = maybeMember.get();
        TVShow tvShow = maybeTVShow.get();

        List<TVShow> watchedTVShows = member.getWatched_tvshows();
        watchedTVShows.add(tvShow);

        List<Member> watched = tvShow.getWatched();
        watched.add(member);

        member.getUnwatched_tvshows().remove(tvShow);

        tvShowDAO.save(tvShow);
        memberDAO.saveMember(member);

        return member.getWatched_tvshows();
    }

    public List<TVShow> removeTVShowFromWatchedList(long memberId, long tvShowId) {
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);
        Optional<TVShow> maybeTVShow = tvShowDAO.findTVShowById(tvShowId);

        if (maybeMember.isEmpty() || maybeTVShow.isEmpty()) {
            return null;
        }

        Member member = maybeMember.get();
        TVShow tvShow = maybeTVShow.get();

        List<TVShow> watchedTVShows = member.getWatched_tvshows();
        watchedTVShows.remove(tvShow);

        List<Member> watched = tvShow.getWatched();
        watched.remove(member);

        List<TVShow> unwatchedTVShows = member.getUnwatched_tvshows();
        unwatchedTVShows.add(tvShow);

        tvShowDAO.save(tvShow);
        memberDAO.saveMember(member);

        return member.getUnwatched_tvshows();
    }
}
