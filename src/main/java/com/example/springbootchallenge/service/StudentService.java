package com.example.springbootchallenge.service;

import com.example.springbootchallenge.model.Student;
import com.example.springbootchallenge.model.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    List<StudentDTO> getAllStudentsByTeacherId(String teacherId);

    StudentDTO getStudentByStudentId(String studentId);

    StudentDTO createStudent(Student newStudent);

    StudentDTO updateStudent(String studentId, String updatedName, String updatedMajor);
}
