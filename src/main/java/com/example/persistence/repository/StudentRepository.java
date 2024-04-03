package com.example.persistence.repository;

import com.example.persistence.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query(value = "SELECT s FROM Student s")
    List<Student> findAllStudents();
}
