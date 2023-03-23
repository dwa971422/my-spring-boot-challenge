package com.example.springbootchallenge.service;

import com.example.springbootchallenge.model.Student;
import com.example.springbootchallenge.model.Teacher;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    List<Teacher> getAllTeachersByStudentId(String studentId);

    Student getStudentByStudentId(String studentId);

    Student createStudent(Student newStudent);

    Student updateStudent(String studentId, Student updatedStudent);
}
