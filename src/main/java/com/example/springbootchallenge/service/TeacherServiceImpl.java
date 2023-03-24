package com.example.springbootchallenge.service;

import com.example.springbootchallenge.model.Teacher;
import com.example.springbootchallenge.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher> getAllTeachersByStudentId(String studentId) {
        return teacherRepository.findAllByStudentsId(studentId);
    }

    @Override
    public Teacher getTeacherByTeacherId(String teacherId) {
        return teacherRepository.findById(teacherId).orElseThrow(() ->
                new NoSuchElementException("Teacher with ID " + teacherId + " NOT FOUND!"));
    }

    @Override
    public Teacher createTeacher(Teacher newTeacher) {
        return teacherRepository.save(newTeacher);
    }

    @Override
    public Teacher updateTeacher(String teacherId, Teacher updatedTeacher) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() ->
                new NoSuchElementException("Teacher with ID " + teacherId + " NOT FOUND!"));

        teacher.setName(updatedTeacher.getName());
        teacher.setStudents(updatedTeacher.getStudents());

        return teacherRepository.save(teacher);
    }
}
