package com.example.springbootchallenge.controller;

import com.example.springbootchallenge.model.Teacher;
import com.example.springbootchallenge.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> result = teacherService.getAllTeachers();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/teachers/{studentId}")
    public ResponseEntity<List<Teacher>> getAllTeachersByStudentId(@PathVariable("studentId") String studentId) {
        List<Teacher> result = teacherService.getAllTeachersByStudentId(studentId);

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("teacher/{teacherId}")
    public ResponseEntity<Teacher> getTeacherByTeacherId(@PathVariable("teacherId") String teacherId) {
        Teacher result;

        try {
            result = teacherService.getTeacherByTeacherId(teacherId);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/teacher")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher newTeacher) {
        Teacher result = teacherService.createTeacher(newTeacher);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/teacher/{teacherId}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("teacherId") String teacherId,
                                                 @RequestBody Teacher updatedTeacher) {
        Teacher result;

        try {
            result = teacherService.updateTeacher(teacherId, updatedTeacher);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
