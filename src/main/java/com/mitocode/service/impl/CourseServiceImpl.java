package com.mitocode.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.mitocode.domain.model.Course;
import com.mitocode.repository.interfaces.ICourseRepo;
import com.mitocode.repository.interfaces.IGenericRepo;
import com.mitocode.service.interfaces.ICourseService;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CrudImpl<Course, Integer> implements ICourseService {

    private final ICourseRepo courseRepo;


    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return courseRepo;
    }
}
