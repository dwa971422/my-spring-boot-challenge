package com.example.springbootchallenge.service;

import com.example.springbootchallenge.model.Teacher;
import com.example.springbootchallenge.model.TeacherDTO;
import com.example.springbootchallenge.model.TeacherDTO.TeacherDTOBuilder;
import com.example.springbootchallenge.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(teacher -> new TeacherDTOBuilder()
                        .setId(teacher.getId())
                        .setName(teacher.getName())
                        .setDepartment(teacher.getDepartment())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<TeacherDTO> getAllTeachersByStudentId(String studentId) {
        return teacherRepository.findAllByStudentsId(studentId)
                .stream()
                .map(teacher -> new TeacherDTOBuilder()
                        .setId(teacher.getId())
                        .setName(teacher.getName())
                        .setDepartment(teacher.getDepartment())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO getTeacherByTeacherId(String teacherId) {
        Teacher foundTeacher = teacherRepository.findById(teacherId).orElseThrow(() ->
                new NoSuchElementException("Teacher with ID " + teacherId + " NOT FOUND!"));

        return new TeacherDTOBuilder()
                .setId(foundTeacher.getId())
                .setName(foundTeacher.getName())
                .setDepartment(foundTeacher.getDepartment())
                .build();
    }

    @Override
    public TeacherDTO createTeacher(Teacher newTeacher) {
        Teacher createdTeacher = teacherRepository.save(newTeacher);

        return new TeacherDTOBuilder()
                .setId(createdTeacher.getId())
                .setName(createdTeacher.getName())
                .setDepartment(createdTeacher.getDepartment())
                .build();
    }

    @Override
    public TeacherDTO updateTeacher(String teacherId, Teacher updatedTeacher) {
        Teacher foundTeacher = teacherRepository.findById(teacherId).orElseThrow(() ->
                new NoSuchElementException("Teacher with ID " + teacherId + " NOT FOUND!"));

        foundTeacher.setName(updatedTeacher.getName());
        foundTeacher.setDepartment(updatedTeacher.getDepartment());
        foundTeacher.setStudents(updatedTeacher.getStudents());

        Teacher savedUpdatedTeacher = teacherRepository.save(foundTeacher);

        return new TeacherDTOBuilder()
                .setId(savedUpdatedTeacher.getId())
                .setName(savedUpdatedTeacher.getName())
                .setDepartment(savedUpdatedTeacher.getDepartment())
                .build();
    }
}
