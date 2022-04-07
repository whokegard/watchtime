package com.example.watchtime.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
    @Column
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "student_sequence",
            strategy = GenerationType.IDENTITY)
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
}
