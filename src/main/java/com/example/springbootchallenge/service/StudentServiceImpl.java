package com.example.springbootchallenge.service;

import com.example.springbootchallenge.model.Student;
import com.example.springbootchallenge.model.Teacher;
import com.example.springbootchallenge.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Teacher> getAllTeachersByStudentId(String studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new NoSuchElementException("Student with ID " + studentId + " NOT FOUND!"));

        return new ArrayList<>(student.getTeachers());
    }

    @Override
    public Student getStudentByStudentId(String studentId) {
        return studentRepository.findById(studentId).orElseThrow(() ->
                new NoSuchElementException("Student with ID " + studentId + " NOT FOUND!"));
    }

    @Override
    public Student createStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @Override
    public Student updateStudent(String studentId, Student updatedStudent) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new NoSuchElementException("Student with ID " + studentId + " NOT FOUND!"));

        student.setName(updatedStudent.getName());
        student.setTeachers(updatedStudent.getTeachers());

        return studentRepository.save(student);
    }
}
