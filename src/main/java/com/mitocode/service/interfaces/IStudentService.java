package com.mitocode.service.interfaces;

import com.mitocode.domain.model.Student;

import java.util.List;

public interface IStudentService extends ICrud<Student, Integer> {

    List<Student> getAllStudentsOrderedByAgeDesc();
}
