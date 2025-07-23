package com.mitocode.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.mitocode.domain.model.Student;
import com.mitocode.repository.interfaces.IGenericRepo;
import com.mitocode.repository.interfaces.IStudentRepo;
import com.mitocode.service.interfaces.IStudentService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CrudImpl<Student, Integer> implements IStudentService {

    private final IStudentRepo studentRepo;


    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return studentRepo;
    }

    @Override
    public List<Student> getAllStudentsOrderedByAgeDesc() {
        return studentRepo.findAll()
                .stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .collect(Collectors.toList());
    }
}
