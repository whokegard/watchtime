package com.example.watchtime.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movie_id;

    @Column
    private String imdb_id;

    @Column
    private String title;

    @Column
    private int year;

    @Column
    @ManyToMany
    @JsonIgnore
    private List<Member> watched;

    @Column
    @ManyToMany
    @JsonIgnore
    private List<Member> member_list;
}
