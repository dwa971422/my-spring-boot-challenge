package com.example.springbootchallenge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "student")
@AllArgsConstructor
public class Student {
    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_teacher",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private Set<Teacher> teachers;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
