package com.example.spring.graph.ql.controllers;

import com.example.spring.graph.ql.models.Course;
import com.example.spring.graph.ql.models.ResponseMessage;
import com.example.spring.graph.ql.resolvers.input.InputCourse;
import com.example.spring.graph.ql.services.CourseService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alanqtruong
 */
@RestController
@Validated
@Slf4j
@RequestMapping("/api/course")
public class CourseController {

  @Resource
  private CourseService courseService;

  /**
   * Retreive all the course
   *
   * @return all the course
   */
  @GetMapping(value = "/")
  public ResponseEntity<List<Course>> listAllCourse() {
    log.info("Fetching all courses");
    List<Course> messages = courseService.findAll();
    return messages.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
        : new ResponseEntity<>(messages, HttpStatus.OK);
  }

  /**
   * Retreive a given course based on course id
   *
   * @param id The course ID
   * @return the Course with the given ID
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity getCourse(@PathVariable("id") long id) {
    log.info("Fetching courses with id {}", id);
    Optional<Course> courseServiceById = courseService.findById(id);
    return courseServiceById.isPresent() ?
        new ResponseEntity<>(courseServiceById.get(), HttpStatus.OK)
        : new ResponseEntity<>(new ResponseMessage("Course not found", new Date()), HttpStatus.OK);
  }

  /**
   * Create a new Course
   *
   * @param course The new Course
   * @return the created Course
   */
  @PostMapping(value = "/")
  public ResponseEntity<Course> createCourse(@Valid @RequestBody InputCourse course) {
    log.info("Creating course {}", course);
    return new ResponseEntity<>(courseService.save(course.convert()), HttpStatus.CREATED);
  }
}
