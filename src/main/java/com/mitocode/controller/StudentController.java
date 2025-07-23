package com.mitocode.controller;

import com.mitocode.domain.dto.StudentDto;
import com.mitocode.domain.model.Student;
import com.mitocode.service.interfaces.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAll() throws Exception {
        List<StudentDto> list = studentService.findAll().stream()
                .map(this::mapToDto)
                .toList();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findById(@PathVariable("id") Integer id) throws Exception {
        StudentDto student = mapToDto(studentService.findById(id));
        return ResponseEntity.ok().body(student);
    }

    @PostMapping
    public ResponseEntity<StudentDto> save(@Valid @RequestBody StudentDto studentDto) throws Exception {
        Student newStudent = studentService.save(mapToEntity(studentDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapToDto(newStudent));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> save(@Valid @PathVariable("id") Integer id, @RequestBody StudentDto studentDto) throws Exception {
        Student updatedStudent = studentService.update(id, mapToEntity(studentDto));
        return ResponseEntity.ok().body(mapToDto(updatedStudent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Questions
    @GetMapping("/students-by-age-desc")
    public ResponseEntity<List<StudentDto>> getAllStudentsOrderedByAgeDesc() throws Exception {
        List<StudentDto> list = studentService.getAllStudentsOrderedByAgeDesc().stream()
                .map(this::mapToDto)
                .toList();
        return ResponseEntity.ok().body(list);
    }

    // Auxiliary mapping functions
    private StudentDto mapToDto(Student student) {
        return modelMapper.map(student, StudentDto.class);
    }

    private Student mapToEntity(StudentDto studentDto) {
        return modelMapper.map(studentDto, Student.class);
    }
}
