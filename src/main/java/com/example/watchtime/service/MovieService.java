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

    //private final OMDBController omdbController;

    public Movie addMovie(Movie newMovie) {
        Movie movie = findByImdbId(newMovie.getImdb_id());

        if (movie != null)
            return null;

        return movieDAO.save(newMovie);
    }

    public List<Movie> getAllMovies() {
        return (List<Movie>) movieDAO.findAllMovies();
    }

    public Movie addMemberToMovie(String imdbId, long memberId) {
        Movie movie = findByImdbId(imdbId);
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);
        if (maybeMember.isEmpty()) {
            return null;
        }
        Member member = maybeMember.get();

        movie.getMember_list().add(member);
        return movie;
    }

    private Movie findByImdbId(String imdbId) {
        return getAllMovies().stream()
                .filter(movie -> movie.getImdb_id().equalsIgnoreCase(imdbId))
                .findFirst().orElse(null);
    }

    /*public List<String> getAllMoviePostersOfAMember(long watchlistId) {
        List<Movie> allMovies = getAllOfAMembersMovies(watchlistId);
        List<String> posters = new ArrayList<>();
        for (Movie m : allMovies) {
            posters.add(omdbController.getPoster(m.getTitle(), m.getYear()));
        }

        return posters;
    }*/
}
