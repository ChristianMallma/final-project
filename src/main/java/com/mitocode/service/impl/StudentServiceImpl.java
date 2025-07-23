package com.mitocode.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.mitocode.model.Student;
import com.mitocode.repository.interfaces.IGenericRepo;
import com.mitocode.repository.interfaces.IStudentRepo;
import com.mitocode.service.interfaces.IStudentService;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CrudImpl<Student, Integer> implements IStudentService {

    private final IStudentRepo studentRepo;


    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return studentRepo;
    }
}
