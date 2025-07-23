package com.mitocode.service.impl;

import com.mitocode.domain.model.Enrollment;
import com.mitocode.repository.interfaces.IGenericRepo;
import com.mitocode.repository.interfaces.IEnrollmentRepo;
import com.mitocode.service.interfaces.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CrudImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepo enrollmentRepo;


    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return enrollmentRepo;
    }
}
