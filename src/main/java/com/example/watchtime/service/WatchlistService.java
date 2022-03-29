package com.example.watchtime.service;

import com.example.watchtime.dao.WatchlistDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WatchlistService {
    private final WatchlistDAO watchlistDAO;

}
