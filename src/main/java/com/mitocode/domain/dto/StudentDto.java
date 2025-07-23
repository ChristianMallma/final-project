package com.mitocode.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDto {

    private Integer idStudent;

    @Size(min = 2, max = 60)
    private String firstName;

    @Size(min = 2, max = 60)
    private String lastName;

    @Size(min = 6, max = 10)
    private String dni;

    @Min(10)
    @Max(99)
    private Integer age;
    private Boolean enabled;
}
