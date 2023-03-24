package com.example.springbootchallenge.repository;

import com.example.springbootchallenge.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {
    List<Teacher> findAllByStudentsId(String studentId);
}
