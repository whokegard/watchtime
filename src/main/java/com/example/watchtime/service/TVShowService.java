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
            return null;

        return tvShowDAO.save(newTVShow);
    }

    public List<TVShow> getAllTVShows() {
        return (List<TVShow>) tvShowDAO.findAllTVShows();
    }

    public TVShow addMemberToTVShow(String imdbId, long memberId) {
        TVShow tvshow = findByImdbId(imdbId);
        Optional<Member> maybeMember = memberDAO.findMemberByID(memberId);
        if (maybeMember.isEmpty()) {
            return null;
        }
        Member member = maybeMember.get();

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

    public List<Member> getAllMembersOfATVShow(String imdbId) {
        TVShow tvshow = findByImdbId(imdbId);
        return tvshow.getMember_list();
    }
}