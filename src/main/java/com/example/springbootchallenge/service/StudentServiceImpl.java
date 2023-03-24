package com.example.springbootchallenge.service;

import com.example.springbootchallenge.model.Student;
import com.example.springbootchallenge.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getAllStudentsByTeacherId(String teacherId) {
        return studentRepository.findAllByTeachersId(teacherId);
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
