package com.example.spring.graph.ql.services;

import com.example.spring.graph.ql.models.Course;
import java.util.List;
import java.util.Optional;

public interface CourseService {

  List<Course> findAll();

  Optional<Course> findById(Long id);

  Course save(Course course);
}
