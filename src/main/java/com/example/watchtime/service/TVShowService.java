package com.example.watchtime.service;

import com.example.watchtime.dao.TVShowDAO;
import com.example.watchtime.model.TVShow;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TVShowService {
    private final TVShowDAO tvShowDAO;

    public TVShow getTVShowById(Long id) {
        Optional<TVShow> idTVShow = tvShowDAO.findTVShowById(id);
        return idTVShow.orElse(null);
    }

    public void deleteTVShowById(long member_id, long tvshow_id) {
        tvShowDAO.deleteById(member_id, tvshow_id);
    }

    public void deleteAllTVShows() {
        tvShowDAO.deleteAllTVShows();
    }
}
