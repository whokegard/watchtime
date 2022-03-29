package com.example.watchtime.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie extends OMDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    @JoinColumn(name = "watchlist_id", referencedColumnName = "id")
    @JsonIgnore
    private int watchlist_id;

    @Column
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    @JsonIgnore
    private int rating_id;
}
