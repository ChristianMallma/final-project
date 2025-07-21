package com.mitocode.service;

import com.mitocode.repository.interfaces.IStudentRepo;
import com.mitocode.service.interfaces.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepo studentRepo;
}
