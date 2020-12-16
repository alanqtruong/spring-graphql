package com.example.spring.graph.ql.repositories;

import com.example.spring.graph.ql.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
