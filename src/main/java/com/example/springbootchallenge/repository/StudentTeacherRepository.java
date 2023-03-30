package com.example.springbootchallenge.repository;

import com.example.springbootchallenge.model.Student_Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentTeacherRepository extends JpaRepository<Student_Teacher, Long> {
    List<Student_Teacher> findAllByStudentId(String studentId);

    List<Student_Teacher> findAllByTeacherId(String teacherId);
}
