package com.example.spring.graph.ql.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Course")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, exclude = {"students"})
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private long courseId;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

}
