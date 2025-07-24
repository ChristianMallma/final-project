package com.mitocode.controller;

import com.mitocode.domain.dto.EnrollmentDto;
import com.mitocode.domain.dto.StudentDto;
import com.mitocode.domain.model.Enrollment;
import com.mitocode.service.interfaces.IEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService enrollmentService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EnrollmentDto>> findAll() throws Exception {
        List<EnrollmentDto> list = enrollmentService.findAll().stream()
                .map(this::mapToDto)
                .toList();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDto> findById(@PathVariable("id") Integer id) throws Exception {
        EnrollmentDto enrollment = mapToDto(enrollmentService.findById(id));
        return ResponseEntity.ok().body(enrollment);
    }

    @PostMapping
    public ResponseEntity<EnrollmentDto> save(@Valid @RequestBody EnrollmentDto enrollmentDto) throws Exception {
        Enrollment newEnrollment = enrollmentService.save(mapToEntity(enrollmentDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapToDto(newEnrollment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDto> save(@Valid @PathVariable("id") Integer id, @RequestBody EnrollmentDto enrollmentDto) throws Exception {
        Enrollment updatedEnrollment = enrollmentService.update(id, mapToEntity(enrollmentDto));
        return ResponseEntity.ok().body(mapToDto(updatedEnrollment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        enrollmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Questions
    @GetMapping("/students-enrolled-by-course")
    public ResponseEntity<Map<String, List<String>>> studentsEnrolledByCourse() throws Exception {
        Map<String, List<String>> list = enrollmentService.studentsEnrolledByCourse();
        return ResponseEntity.ok().body(list);
    }

    // Auxiliary mapping functions
    private EnrollmentDto mapToDto(Enrollment enrollment) {
        return modelMapper.map(enrollment, EnrollmentDto.class);
    }

    private Enrollment mapToEntity(EnrollmentDto enrollmentDto) {
        return modelMapper.map(enrollmentDto, Enrollment.class);
    }
}
