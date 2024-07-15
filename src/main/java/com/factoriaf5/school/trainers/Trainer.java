package com.factoriaf5.school.trainers;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Builder
@Table(name = "trainers")
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

}
