package com.mitocode.controller;

import com.mitocode.domain.dto.CourseDto;
import com.mitocode.domain.model.Course;
import com.mitocode.service.interfaces.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService courseService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CourseDto>> findAll() throws Exception {
        List<CourseDto> list = courseService.findAll().stream()
                .map(this::mapToDto)
                .toList();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> findById(@PathVariable("id") Integer id) throws Exception {
        CourseDto course = mapToDto(courseService.findById(id));
        return ResponseEntity.ok().body(course);
    }

    @PostMapping
    public ResponseEntity<CourseDto> save(@Valid @RequestBody CourseDto courseDto) throws Exception {
        Course newCourse = courseService.save(mapToEntity(courseDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapToDto(newCourse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> save(@Valid @PathVariable("id") Integer id, @RequestBody CourseDto courseDto) throws Exception {
        Course updatedCourse = courseService.update(id, mapToEntity(courseDto));
        return ResponseEntity.ok().body(mapToDto(updatedCourse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Auxiliary mapping functions
    private CourseDto mapToDto(Course course) {
        return modelMapper.map(course, CourseDto.class);
    }

    private Course mapToEntity(CourseDto courseDto) {
        return modelMapper.map(courseDto, Course.class);
    }
}
