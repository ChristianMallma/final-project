package com.mitocode.repository.interfaces;

import com.mitocode.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student, Integer> {
}
