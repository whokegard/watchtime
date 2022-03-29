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
@Table(name="watchlist")
public class Watchlist {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @JsonIgnore
    private int member_id;

}
