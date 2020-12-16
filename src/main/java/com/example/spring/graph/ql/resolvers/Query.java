package com.example.spring.graph.ql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.spring.graph.ql.models.Course;
import com.example.spring.graph.ql.models.Student;
import com.example.spring.graph.ql.services.CourseService;
import com.example.spring.graph.ql.services.StudentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    @Resource
    private StudentService studentService;

    @Resource
    private CourseService courseService;

    public List<Student> students() {
        return studentService.findAll();
    }

    public Optional<Student> student(final Long id) {
        return studentService.findById(id);
    }

    public List<Course> courses() {
        return courseService.findAll();
    }

    public Optional<Course> course(final Long id) {
        return courseService.findById(id);
    }

}
