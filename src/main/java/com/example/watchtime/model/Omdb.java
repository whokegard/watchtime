package com.example.watchtime.model;

import lombok.*;
import javax.persistence.Column;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class OMDB {

    @Column
    private String title;

    @Column
    private int year;

    @Column
    private String type;
}
