package com.example.watchtime.model;

import lombok.*;
import javax.persistence.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tvshow")
public class TVShow {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long show_id;

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
    private byte isWatched;
}
