package com.example.springbootchallenge.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teacher")
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @Column
    private String id;

    @Column()
    private String name;

    @ManyToMany(mappedBy = "teachers")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            scope = Student.class
    )
    @JsonIdentityReference(alwaysAsId=true)
    private Set<Student> students;

    public Teacher(String id, String name) {
        this.id = id;
        this.name = name;
        this.students = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
