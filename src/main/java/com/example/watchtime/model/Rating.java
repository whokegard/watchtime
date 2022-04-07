package com.example.watchtime.model;

import com.example.watchtime.model.enums.RatingEnum;
import lombok.*;
import javax.persistence.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rating")
public class Rating {
    @Id
    @Column
    @GeneratedValue
    private byte id;

    @Column
    @Enumerated(EnumType.ORDINAL) //Kanske @Enumerated(EnumType.STRING)
    private RatingEnum rating;
}