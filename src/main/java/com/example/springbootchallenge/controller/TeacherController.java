package com.example.springbootchallenge.controller;

import com.example.springbootchallenge.model.Teacher;
import com.example.springbootchallenge.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> result = teacherService.getAllTeachers();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
