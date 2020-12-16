package com.example.spring.graph.ql.services;

import com.example.spring.graph.ql.models.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {

  List<Student> findAll();

  Optional<Student> findById(Long id);

  Student save(Student student);

  Student addStudentToCourse(Long studentId, Long courseId);


}
