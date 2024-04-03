package com.example.service;

import com.example.persistence.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO findById(Long id);
    List<StudentDTO> findAll();
    void save(StudentDTO studentDTO);
    void deleteById(Long id);
}
