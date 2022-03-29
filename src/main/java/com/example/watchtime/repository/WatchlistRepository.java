package com.example.watchtime.repository;

import com.example.watchtime.model.Watchlist;
import org.springframework.data.repository.CrudRepository;

public interface WatchlistRepository extends CrudRepository<Watchlist, Integer> {
}
