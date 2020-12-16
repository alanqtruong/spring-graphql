package com.example.spring.graph.ql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.spring.graph.ql.models.Course;
import com.example.spring.graph.ql.models.Student;
import com.example.spring.graph.ql.resolvers.input.InputCourse;
import com.example.spring.graph.ql.resolvers.input.InputStudent;
import com.example.spring.graph.ql.services.CourseService;
import com.example.spring.graph.ql.services.StudentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Resource
    private StudentService studentService;

    @Resource
    private CourseService courseService;

    public Student addStudent(InputStudent student) {
        return studentService.save(student.convert());
    }

    public Course addCourse(InputCourse course) {
        return courseService.save(course.convert());
    }

    public Student addStudentToCourse(Long studentId, Long courseId) {
        return studentService.addStudentToCourse(studentId, courseId);
    }
}
