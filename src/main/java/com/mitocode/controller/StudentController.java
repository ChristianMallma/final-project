package com.mitocode.controller;

import com.mitocode.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public Student getStudent() {
        return new Student(1,"Christian", "Mallma", "44693306", 38);
    }
}
