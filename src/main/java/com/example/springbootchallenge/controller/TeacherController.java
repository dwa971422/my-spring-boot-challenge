package com.example.springbootchallenge.controller;

import com.example.springbootchallenge.model.Teacher;
import com.example.springbootchallenge.model.TeacherDTO;
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
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        List<TeacherDTO> result = teacherService.getAllTeachers();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/teachers/{studentId}")
    public ResponseEntity<List<TeacherDTO>> getAllTeachersByStudentId(@PathVariable("studentId") String studentId) {
        List<TeacherDTO> result = teacherService.getAllTeachersByStudentId(studentId);

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("teacher/{teacherId}")
    public ResponseEntity<TeacherDTO> getTeacherByTeacherId(@PathVariable("teacherId") String teacherId) {
        TeacherDTO result;

        try {
            result = teacherService.getTeacherByTeacherId(teacherId);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/teacher")
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody Teacher newTeacher) {
        TeacherDTO result = teacherService.createTeacher(newTeacher);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/teacher/{teacherId}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable("teacherId") String teacherId,
                                                    @RequestBody Teacher updatedTeacher) {
        TeacherDTO result;

        try {
            result = teacherService.updateTeacher(teacherId, updatedTeacher);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
