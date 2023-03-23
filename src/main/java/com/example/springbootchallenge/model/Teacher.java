package com.example.springbootchallenge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "teacher")
@AllArgsConstructor
public class Teacher {
    @Id
    @Column(name = "teacher_id")
    private String teacherId;

    @Column(name = "name")
    private String name;

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "teachers"
    )
    private Set<Student> students;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
