package com.example.spring.graph.ql.resolvers.input;

import com.example.spring.graph.ql.models.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author atruon on 2020-12-14
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputCourse implements Serializable {

    @NotEmpty
    @NotBlank(message = "Course name cannot be blank")
    private String courseName;

    public Course convert() {
        return convert(this);
    }

    private static Course convert(InputCourse course) {
        return course != null ? new Course(course.courseName) : null;
    }

}
