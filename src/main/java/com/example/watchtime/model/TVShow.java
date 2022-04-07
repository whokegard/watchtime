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
@Table(name = "tvshow")
public class TVShow {
    @Id
    @Column
    @GeneratedValue
    private long tvshow_id;

    @Column
    private String imdb_id;

    @Column
    private String title;

    @Column
    private int year;

    @Column
    private byte watched;

    @Column
    @ManyToMany
    @JsonIgnore
    private List<Member> member_list;

    @Column
    @ManyToMany
    @JsonIgnore
    private List<Rating> rating_list;
}
