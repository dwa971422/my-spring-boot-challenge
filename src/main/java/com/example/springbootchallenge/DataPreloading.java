package com.example.springbootchallenge;

import com.example.springbootchallenge.model.Student;
import com.example.springbootchallenge.model.Teacher;
import com.example.springbootchallenge.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Order(value = 1)
@Component
public class DataPreloading implements CommandLineRunner {
    private final StudentService studentService;

    @Autowired
    public DataPreloading(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student("kn95", "Ken", "CS", new HashSet<>());
        Student student2 = new Student("dv97", "David", "ME", new HashSet<>());
        Student student3 = new Student("ug98", "Ugo", "Math", new HashSet<>());

        Teacher teacher1 = new Teacher("bf76", "Biff", "CS", new HashSet<>());
        Teacher teacher2 = new Teacher("jm63", "James", "ME", new HashSet<>());
        Teacher teacher3 = new Teacher("mk55", "Mack", "Math", new HashSet<>());
        Teacher teacher4 = new Teacher("ch70", "Chris", "Physics", new HashSet<>());

        student1.getTeachers().add(teacher1);
        student1.getTeachers().add(teacher2);

        student2.getTeachers().add(teacher3);
        student2.getTeachers().add(teacher4);

        student3.getTeachers().add(teacher1);
        student3.getTeachers().add(teacher2);
        student3.getTeachers().add(teacher3);
        student3.getTeachers().add(teacher4);

        studentService.createStudent(student1);
        studentService.createStudent(student2);
        studentService.createStudent(student3);
    }
}
