package com.example.springbootchallenge.service;

import com.example.springbootchallenge.model.Teacher;
import com.example.springbootchallenge.model.TeacherDTO;

import java.util.List;

public interface TeacherService {
    List<TeacherDTO> getAllTeachers();

    List<TeacherDTO> getAllTeachersByStudentId(String studentId);

    TeacherDTO getTeacherByTeacherId(String teacherId);

    TeacherDTO createTeacher(Teacher newTeacher);

    TeacherDTO updateTeacher(String teacherId, Teacher updatedTeacher);
}
