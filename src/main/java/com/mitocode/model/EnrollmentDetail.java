package com.mitocode.model;

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
public class EnrollmentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEnrollmentDetail;

    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false, foreignKey =  @ForeignKey(name = "fk_detail_course"))
    private Course course;

    @ManyToOne
    @JoinColumn(name = "id_enrollment", nullable = false, foreignKey =  @ForeignKey(name = "fk_detail_enrollment"))
    private Enrollment enrollment;

    @Column(nullable = false, length = 60)
    private String classroom;

    @Column(nullable = false)
    private boolean enabled;
}
