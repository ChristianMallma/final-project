package com.mitocode.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Integer idStudent;
    private String firstName;
    private String lastName;
    private String dni;
    private Integer age;
    private boolean enabled;
}
