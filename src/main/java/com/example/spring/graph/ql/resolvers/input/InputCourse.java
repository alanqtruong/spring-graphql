package com.example.spring.graph.ql.resolvers.input;

import com.example.spring.graph.ql.models.Course;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atruon on 2020-12-14
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputCourse implements Serializable {

  private String courseName;

  public Course convert() {
    return convert(this);
  }

  private static Course convert(InputCourse course) {
    return course != null ? new Course(course.courseName) : null;
  }

}
