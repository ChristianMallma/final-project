package com.mitocode.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private Integer idCourse;

    @Size(min = 2, max = 60)
    private String name;

    @Size(min = 2, max = 20)
    private String code;

    private boolean enabled;
}
