package com.example.watchtime.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="tvshow")
public class TVShow {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "watchlist_id", referencedColumnName = "id")
    @JsonIgnore
    private Watchlist watchlist;

    @ManyToOne
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    @JsonIgnore
    private Rating rating;

    @Column
    private String title;

    @Column
    private int episodes;

    @Column
    private int seasons;

    @Column
    private int imdbRating;

    @Column
    private boolean watched;






}
