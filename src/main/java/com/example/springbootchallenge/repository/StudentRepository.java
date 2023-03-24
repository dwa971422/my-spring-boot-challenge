package com.example.springbootchallenge.repository;

import com.example.springbootchallenge.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findAllByTeachersId(String teacherId);
}
