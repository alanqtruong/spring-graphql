package com.example.spring.graph.ql.resolvers.input;

import com.example.spring.graph.ql.models.Student;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atruon on 2020-12-14
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputStudent implements Serializable {

  @NotEmpty
  @NotBlank(message = "First name cannot be blank")
  private String firstName;

  @NotEmpty
  @NotBlank(message = "Last name cannot be blank")
  private String lastName;

  public Student convert() {
    return convert(this);
  }

  private static Student convert(InputStudent student) {
    return student != null ? new Student(student.firstName, student.lastName) : null;
  }

}
