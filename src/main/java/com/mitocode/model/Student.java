package com.mitocode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer idStudent;
    private String firstName;
    private String lastName;
    private String dni;
    private Integer age;

}
