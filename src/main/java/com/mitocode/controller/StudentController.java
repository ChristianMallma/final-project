package com.mitocode.controller;

import com.mitocode.model.Student;
import com.mitocode.service.interfaces.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @GetMapping
    public List<Student> findAll() throws Exception {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") Integer id) throws Exception {
        return studentService.findById(id);
    }

    @PostMapping
    public Student save(@RequestBody Student student) throws Exception {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student save(@PathVariable("id") Integer id, @RequestBody Student student) throws Exception {
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        studentService.delete(id);
    }
}
