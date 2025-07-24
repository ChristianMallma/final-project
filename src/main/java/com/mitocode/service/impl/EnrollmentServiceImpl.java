package com.mitocode.service.impl;

import com.mitocode.domain.model.Enrollment;
import com.mitocode.repository.interfaces.IGenericRepo;
import com.mitocode.repository.interfaces.IEnrollmentRepo;
import com.mitocode.service.interfaces.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CrudImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepo enrollmentRepo;


    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return enrollmentRepo;
    }

    @Override
    public Map<String, List<String>> studentsEnrolledByCourse() {
        return enrollmentRepo.findAll()
                .stream()
                .flatMap(enrollment -> enrollment.getDetails().stream()
                        .map(detail -> Map.entry(
                                detail.getCourse().getName(),
                                enrollment.getStudent().getFirstName() + " " + enrollment.getStudent().getLastName()
                        ))
                )
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));
    }
}
