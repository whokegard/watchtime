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
    private Long id;

    /*@OneToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @JsonIgnore
    private Member member;
    */
}
