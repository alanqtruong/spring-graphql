package com.example.spring.graph.ql.controllers;

import com.example.spring.graph.ql.models.ResponseMessage;
import com.example.spring.graph.ql.models.Student;
import com.example.spring.graph.ql.resolvers.input.InputStudent;
import com.example.spring.graph.ql.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author alanqtruong
 */
@RestController
@Validated
@Slf4j
@RequestMapping("/api/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * Retreive all the students
     *
     * @return all the students
     */
    @GetMapping(value = "/")
    public ResponseEntity<List<Student>> listAllStudents() {
        log.info("Fetching all students");
        List<Student> messages = studentService.findAll();
        return messages.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(messages, HttpStatus.OK);
    }

    /**
     * Retreive a given student based on student id
     *
     * @param id The student ID
     * @return the Student with the given ID
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity getStudent(@PathVariable("id") long id) {
        log.info("Fetching student with id {}", id);
        Optional<Student> studentServiceById = studentService.findById(id);
        return studentServiceById.isPresent() ?
                new ResponseEntity<>(studentServiceById.get(), HttpStatus.OK)
                : new ResponseEntity<>(new ResponseMessage("Student not found", new Date()), HttpStatus.OK);
    }

    /**
     * Create a new Student
     *
     * @param student The new student
     * @return the created student
     */
    @PostMapping(value = "/")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody InputStudent student) {
        log.info("Creating student {}", student);
        return new ResponseEntity<>(studentService.save(student.convert()), HttpStatus.CREATED);
    }

    /**
     * Add student to a course
     *
     * @param studentId the Student ID
     * @param courseId  the course ID
     * @return the updated student
     */
    @PostMapping(value = "/add-course")
    public ResponseEntity<Student> addStudentToCourse(
            @Valid @RequestParam("studentId") Long studentId,
            @Valid @RequestParam("courseId") Long courseId) {
        log.info("Adding student {} to course {}", studentId, courseId);
        return new ResponseEntity<>(studentService.addStudentToCourse(studentId, courseId),
                HttpStatus.OK);
    }
}
