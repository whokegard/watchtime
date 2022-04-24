package com.example.watchtime.service;

import com.example.watchtime.dao.MemberDAO;
import com.example.watchtime.dao.TVShowDAO;
import com.example.watchtime.model.Member;
import com.example.watchtime.model.TVShow;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TVShowService {

    private final TVShowDAO tvShowDAO;
    private final MemberDAO memberDAO;

    public TVShow addTVShow(TVShow newTVShow) {
        TVShow tvshow = findByImdbId(newTVShow.getImdb_id());

        if (tvshow != null)
            return tvshow;

        return tvShowDAO.save(newTVShow);
    }

    public TVShow addMemberToTVShow(long tvShowId, long memberId) {
        Optional<TVShow> maybeTVShow = tvShowDAO.findTVShowById(tvShowId);
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);
        if (maybeMember.isEmpty() || maybeTVShow.isEmpty()) {
            return null;
        }
        Member member = maybeMember.get();
        TVShow tvshow = maybeTVShow.get();

        List<Member> members = tvshow.getMember_list();
        members.add(member);

        List<TVShow> tvShows = member.getUnwatched_tvshows();
        tvShows.add(tvshow);

        tvshow.setMember_list(members);
        member.setUnwatched_tvshows(tvShows);
        return tvShowDAO.save(tvshow);
    }

    private TVShow findByImdbId(String imdbId) {
        return getAllTVShows().stream()
                .filter(tvShow -> tvShow.getImdb_id().equalsIgnoreCase(imdbId))
                .findFirst().orElse(null);
    }

    private List<TVShow> getAllTVShows() {
        return (List<TVShow>) tvShowDAO.findAllTVShows();
    }
}