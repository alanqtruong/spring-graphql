package com.example.spring.graph.ql.services;

import com.example.spring.graph.ql.models.Student;
import com.example.spring.graph.ql.repositories.CourseRepository;
import com.example.spring.graph.ql.repositories.StudentRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

  @Resource
  private StudentRepository studentRepository;

  @Resource
  private CourseRepository courseRepository;

  @Override
  public List<Student> findAll() {
    return StreamSupport.stream(studentRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<Student> findById(Long id) {
    return studentRepository.findById(id);
  }

  @Override
  public Student save(Student student) {
    return studentRepository.save(student);
  }

  @Override
  public Student addStudentToCourse(Long studentId, Long courseId) {
    Student student = studentRepository.findById(studentId).get();
    student.getCourses().add(courseRepository.findById(courseId).get());
    return save(student);
  }
}
