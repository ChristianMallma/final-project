package com.mitocode.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCourse;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, length = 20, unique = true)
    private String code;

    @Column(nullable = false)
    private boolean enabled = true;
}
