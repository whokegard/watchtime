package com.example.watchtime.dao;

import com.example.watchtime.repository.WatchlistRepository;
import org.springframework.stereotype.Repository;

@Repository
public class WatchlistDAO {
    WatchlistRepository repository;

    public WatchlistDAO(WatchlistRepository repository) {
        this.repository = repository;
    }

}
