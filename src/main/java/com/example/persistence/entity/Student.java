package com.example.persistence.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "students")
public @Entity class Student{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotEmpty
        private String name;
        @NotNull
        private Integer age;
        @NotEmpty
        @Email
        private String email;
        @NotNull
        private Integer phone;
}
