package com.mitocode.service.interfaces;

import com.mitocode.model.Student;

import java.util.List;

public interface IStudentService {

    Student save(Student student) throws Exception;
    Student update(Integer id, Student student) throws Exception;
    List<Student> findAll() throws Exception;
    Student findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
