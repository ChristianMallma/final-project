package com.mitocode.domain.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDetailDto {

    @JsonBackReference
    private EnrollmentDto enrollment;

    @NotNull
    @JsonIncludeProperties(value = { "idCourse" })
    private CourseDto course;

    @NotNull
    @Size(min = 2, max = 60)
    private String classroom;
}
