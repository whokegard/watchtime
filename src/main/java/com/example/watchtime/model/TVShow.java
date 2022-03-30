package com.example.watchtime.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="tvshow")
@NoArgsConstructor
@AllArgsConstructor
public class TVShow extends OMDB {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tvshow_id;

    @Column
    @JoinColumn(name = "watchlist_id", referencedColumnName = "id")
    @JsonIgnore
    private int watchlist_id;

    @Column
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    @JsonIgnore
    private int rating_id;
}
