package com.mitocode.domain.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EnrollmentDetailDto {

    @JsonBackReference
    private EnrollmentDto enrollment;

    @NotNull
    @JsonIncludeProperties(value = { "idCourse" })
    private CourseDto course;

    @NotNull
    @Size(min = 2, max = 60)
    private String classroom;

    @NotNull
    private Boolean enabled;
}
