package com.example.controller;

import com.example.persistence.dto.StudentDTO;
import com.example.graphql.StudentInput;
import com.example.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class StudentGraphQLController {

    private final StudentService studentService;

    @QueryMapping(name = "findAllStudents")
    public List<StudentDTO> findAll() {
        return studentService.findAll();
    }

    @QueryMapping(name = "findStudentById")
    public StudentDTO findById(@Argument(name = "studentId") String id) {
        return studentService.findById(Long.valueOf(id));
    }

    @MutationMapping(name = "createStudent")
    public String create(@Argument StudentInput studentInput){

        StudentDTO studentDTO = StudentDTO.builder()
                .name(studentInput.name())
                .age(studentInput.age())
                .email(studentInput.email())
                .phone(Integer.valueOf(studentInput.phone()))
                .build();

        studentService.save(studentDTO);

        return "Student created successfully!";
    }

    @MutationMapping(name = "deleteStudentById")
    public String delete(@Argument(name = "studentId") String id){
        studentService.deleteById(Long.valueOf(id));
        return "Student deleted successfully!";
    }
}
