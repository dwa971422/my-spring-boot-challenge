package com.example.springbootchallenge.controller;

import com.example.springbootchallenge.model.Student;
import com.example.springbootchallenge.model.Teacher;
import com.example.springbootchallenge.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> result = studentService.getAllStudents();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentByStudentId(@PathVariable("id") String studentId) {
        Student result;

        try {
            result = studentService.getStudentByStudentId(studentId);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/student/{id}/get-teachers")
    public ResponseEntity<List<Teacher>> getAllTeachersByStudentId(@PathVariable("id") String studentId) {
        List<Teacher> result;

        try {
            result = studentService.getAllTeachersByStudentId(studentId);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student newStudent) {
        Student result = studentService.createStudent(newStudent);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") String studentId,
                                                 @RequestBody Student updatedStudent) {
        Student result;

        try {
            result = studentService.updateStudent(studentId, updatedStudent);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
