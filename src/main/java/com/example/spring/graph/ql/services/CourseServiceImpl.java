package com.example.spring.graph.ql.services;

import com.example.spring.graph.ql.models.Course;
import com.example.spring.graph.ql.repositories.CourseRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

  @Resource
  private CourseRepository courseRepository;

  @Override
  public List<Course> findAll() {
    return StreamSupport.stream(courseRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<Course> findById(Long id) {
    return courseRepository.findById(id);
  }

  @Override
  public Course save(Course course) {
    return courseRepository.save(course);
  }
}
