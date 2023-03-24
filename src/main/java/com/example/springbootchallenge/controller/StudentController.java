package com.example.springbootchallenge.controller;

import com.example.springbootchallenge.model.Student;
import com.example.springbootchallenge.model.StudentDTO;
import com.example.springbootchallenge.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> result = studentService.getAllStudents();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/students/{teacherId}")
    public ResponseEntity<List<StudentDTO>> getAllStudentsByTeacherId(@PathVariable("teacherId") String teacherId) {
        List<StudentDTO> result = studentService.getAllStudentsByTeacherId(teacherId);

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<StudentDTO> getStudentByStudentId(@PathVariable("studentId") String studentId) {
        StudentDTO result;

        try {
            result = studentService.getStudentByStudentId(studentId);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody Student newStudent) {
        StudentDTO result = studentService.createStudent(newStudent);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/student/{studentId}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable("studentId") String studentId,
                                                    @RequestBody Student updatedStudent) {
        StudentDTO result;

        try {
            result = studentService.updateStudent(studentId, updatedStudent);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
