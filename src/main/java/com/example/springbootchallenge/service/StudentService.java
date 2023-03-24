package com.example.springbootchallenge.service;

import com.example.springbootchallenge.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    List<Student> getAllStudentsByTeacherId(String teacherId);

    Student getStudentByStudentId(String studentId);

    Student createStudent(Student newStudent);

    Student updateStudent(String studentId, Student updatedStudent);
}
