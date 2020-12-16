package com.example.spring.graph.ql.config;

import com.example.spring.graph.ql.models.Course;
import com.example.spring.graph.ql.models.Student;
import com.example.spring.graph.ql.services.CourseService;
import com.example.spring.graph.ql.services.StudentService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class DataLoader {

    @Resource
    private CourseService courseService;

    @Resource
    StudentService studentService;

    @PostConstruct
    public void loadData() {
        loadStudents();
        loadCourses();
        loadStudentToCourse();
    }

    private void loadStudents() {
        studentService.save(new Student("John", "Smith"));
        studentService.save(new Student("Ben", "Johnson"));
        studentService.save(new Student("Luke", "Skywalker"));
        studentService.save(new Student("Han", "Solo"));
    }

    private void loadCourses() {
        courseService.save(new Course("Algebra"));
        courseService.save(new Course("Science"));
        courseService.save(new Course("History"));
        courseService.save(new Course("Spanish"));
        courseService.save(new Course("English"));
        courseService.save(new Course("PE"));
        courseService.save(new Course("Theater"));
        courseService.save(new Course("Calculus"));
        courseService.save(new Course("Physics"));
        courseService.save(new Course("Chemistry"));
        courseService.save(new Course("Graphic Design"));
    }

    private void loadStudentToCourse() {
        studentService.addStudentToCourse(1L, 1L);
        studentService.addStudentToCourse(1L, 2L);
        studentService.addStudentToCourse(1L, 3L);
        studentService.addStudentToCourse(1L, 9L);
        studentService.addStudentToCourse(2L, 1L);
        studentService.addStudentToCourse(2L, 4L);
        studentService.addStudentToCourse(2L, 5L);
        studentService.addStudentToCourse(3L, 2L);
        studentService.addStudentToCourse(3L, 6L);
        studentService.addStudentToCourse(3L, 8L);
        studentService.addStudentToCourse(4L, 7L);
        studentService.addStudentToCourse(4L, 10L);
        studentService.addStudentToCourse(4L, 11L);
    }

}
