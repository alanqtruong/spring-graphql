package com.example.spring.graph.ql.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

  @NotEmpty
  @Column(name = "course_name", nullable = false)
  @NotBlank(message = "Course name cannot be blank")
  private String courseName;

  @JsonBackReference
  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "courses")
  private Set<Student> students = new HashSet<>();

  public Course(String courseName) {
    this.courseName = courseName;
  }

}
