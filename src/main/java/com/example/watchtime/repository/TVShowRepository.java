package com.example.watchtime.repository;

import com.example.watchtime.model.TVShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TVShowRepository extends JpaRepository<TVShow, Long> {
}
