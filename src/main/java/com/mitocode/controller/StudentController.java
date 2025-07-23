package com.mitocode.controller;

import com.mitocode.model.Student;
import com.mitocode.service.interfaces.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> findAll() throws Exception {
        List<Student> list = studentService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") Integer id) throws Exception {
        Student student = studentService.findById(id);
        return ResponseEntity.ok().body(student);
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) throws Exception {
        Student newStudent = studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> save(@PathVariable("id") Integer id, @RequestBody Student student) throws Exception {
        Student updatedStudent = studentService.update(id, student);
        return ResponseEntity.ok().body(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
