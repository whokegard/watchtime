package com.example.watchtime.service;

import com.example.watchtime.dao.WatchlistDAO;
import org.springframework.stereotype.Service;

@Service
public class WatchlistService {
    WatchlistDAO watchlistDAO;

    public WatchlistService(WatchlistDAO watchlistDAO) {
        this.watchlistDAO = watchlistDAO;
    }
}
