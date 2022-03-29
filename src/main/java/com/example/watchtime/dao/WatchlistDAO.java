package com.example.watchtime.dao;

import com.example.watchtime.repository.WatchlistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class WatchlistDAO {
    private final  WatchlistRepository watchlistRepository;

}
