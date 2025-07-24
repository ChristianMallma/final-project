package com.mitocode.service.interfaces;

import com.mitocode.domain.model.Enrollment;

import java.util.List;
import java.util.Map;

public interface IEnrollmentService extends ICrud<Enrollment, Integer> {
    Map<String, List<String>> studentsEnrolledByCourse();
}
