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
    private String year;

    @Column
    @ManyToMany
    @JsonIgnore
    private List<Member> watched;

    @Column
    @ManyToMany
    @JsonIgnore
    private List<Member> member_list;
}
