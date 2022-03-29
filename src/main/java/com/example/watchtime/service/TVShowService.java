package com.example.watchtime.service;

import com.example.watchtime.dao.TVShowDAO;
import com.example.watchtime.model.TVShow;
import org.springframework.stereotype.Service;

@Service
public class TVShowService {
    TVShowDAO tvShowDAO;

    public TVShowService(TVShowDAO tvShowDAO) {
        this.tvShowDAO = tvShowDAO;
    }

    public TVShow getTVShowById(Integer id) {
    }
}
