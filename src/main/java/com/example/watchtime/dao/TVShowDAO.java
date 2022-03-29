package com.example.watchtime.dao;

import com.example.watchtime.repository.TVShowRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TVShowDAO {
    TVShowRepository repository;

    public TVShowDAO(TVShowRepository repository) {
        this.repository = repository;
    }

}
