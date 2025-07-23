package com.mitocode.domain.dto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public class EnrollmentDto {

    private Integer idEnrollment;

    @NotNull
    @JsonIncludeProperties(value = { "idStudent" })
    private StudentDto student;

    @NotNull
    private LocalDateTime dateTime;

    @NotNull
    private Boolean enabled;

    @NotNull
    @JsonManagedReference
    private List<EnrollmentDetailDto> details;
}
