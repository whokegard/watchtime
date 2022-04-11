package com.example.watchtime.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long member_id;

    @Column
    private String username;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    @ManyToMany
    private List<Movie> watched_movies;

    @Column
    @ManyToMany
    private List<TVShow> watched_tvshows;

    @Column
    @ManyToMany
    private List<Movie> unwatched_movies;

    @Column
    @ManyToMany
    private List<TVShow> unwatched_tvshows;
}
