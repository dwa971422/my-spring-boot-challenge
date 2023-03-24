package com.example.springbootchallenge.service;

import com.example.springbootchallenge.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    List<Teacher> getAllTeachersByStudentId(String studentId);

    Teacher getTeacherByTeacherId(String teacherId);

    Teacher createTeacher(Teacher newTeacher);

    Teacher updateTeacher(String teacherId, Teacher updatedTeacher);
}
