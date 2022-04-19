package com.example.watchtime.service;

import com.example.watchtime.dao.MemberDAO;
import com.example.watchtime.dao.MovieDAO;
import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieDAO movieDAO;
    private final MemberDAO memberDAO;

    public Movie addMovie(Movie newMovie) {
        Movie movie = findByImdbId(newMovie.getImdb_id());

        if (movie != null) {
            return movie;
        }

        return movieDAO.save(newMovie);
    }


    public Movie addMemberToMovie(long movieId, long memberId) {
        Optional<Movie> maybeMovie = movieDAO.findMovieById(movieId);
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);
        if (maybeMember.isEmpty() || maybeMovie.isEmpty()) {
            return null;
        }

        Member member = maybeMember.get();
        Movie movie = maybeMovie.get();

        List<Member> members = movie.getMember_list();
        members.add(member);

        List<Movie> movies = member.getUnwatched_movies();
        movies.add(movie);

        movie.setMember_list(members);
        member.setUnwatched_movies(movies);
        return movieDAO.save(movie);
    }

    private Movie findByImdbId(String imdbId) {
        return getAllMovies().stream()
                .filter(movie -> movie.getImdb_id().equalsIgnoreCase(imdbId))
                .findFirst()
                .orElse(null);
    }

    private List<Movie> getAllMovies() {
        return (List<Movie>) movieDAO.findAllMovies();
    }
}
