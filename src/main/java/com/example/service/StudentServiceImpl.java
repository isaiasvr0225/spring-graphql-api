package com.example.service;

import com.example.persistence.entity.Student;
import com.example.persistence.dto.StudentDTO;
import com.example.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;


    @Override
    public StudentDTO findById(Long id) {

        Student student = studentRepository.findById(id).orElse(null);
        assert student != null;

        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .age(student.getAge())
                .email(student.getEmail())
                .phone(student.getPhone())
                .build();
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAllStudents().stream()
                .map(student -> StudentDTO.builder()
                        .id(student.getId())
                        .name(student.getName())
                        .age(student.getAge())
                        .email(student.getEmail())
                        .phone(student.getPhone())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void save(StudentDTO studentDTO) {
        Student student = Student.builder()
                .id(studentDTO.id())
                .name(studentDTO.name())
                .age(studentDTO.age())
                .email(studentDTO.email())
                .phone(studentDTO.phone())
                .build();

        studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
