package com.mitocode.service;

import com.mitocode.model.Student;
import com.mitocode.repository.interfaces.IStudentRepo;
import com.mitocode.service.interfaces.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepo studentRepo;

    @Override
    public Student save(Student student) throws Exception {
        return studentRepo.save(student);
    }

    @Override
    public Student update(Integer id, Student student) throws Exception {
        student.setIdStudent(id);
        return studentRepo.save(student);
    }

    @Override
    public List<Student> findAll() throws Exception {
        return studentRepo.findAll();
    }

    @Override
    public Student findById(Integer id) throws Exception {
        return studentRepo.findById(id).orElse(new Student());
    }

    @Override
    public void delete(Integer id) throws Exception {
        studentRepo.deleteById(id);
    }
}
