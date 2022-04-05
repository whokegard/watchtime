package com.example.watchtime.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie extends OMDB {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movie_id;

    @Column
    private String imdb_id;

    @Column
   /* @JoinColumn(name = "watchlist_id", referencedColumnName = "id")
    @JsonIgnore*/
    private int watchlist_id;

    @Column
    /*@JoinColumn(name = "rating_id", referencedColumnName = "id")
    @JsonIgnore*/
    private int rating_id;

    @Column
    /*@JoinColumn(name = "rating_id", referencedColumnName = "id")
    @JsonIgnore*/
    private int watched_id;
}
