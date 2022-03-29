package com.example.watchtime.model;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private int watchlistId;

    @Column
    private boolean watched;

    @Column
    private int ratingId;

    @Column
    private int imdbRating;

    @Column
    private int runtime;

    @Column
    private String title;
}
