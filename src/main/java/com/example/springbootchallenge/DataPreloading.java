package com.example.springbootchallenge;

import com.example.springbootchallenge.model.Student;
import com.example.springbootchallenge.model.Teacher;
import com.example.springbootchallenge.service.StudentService;
import com.example.springbootchallenge.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = 1)
@Component
public class DataPreloading implements CommandLineRunner {
    private final StudentService studentService;

    private final TeacherService teacherService;

    @Autowired
    public DataPreloading(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student("kn95", "Ken");
        Student student2 = new Student("dv97", "David");
        Student student3 = new Student("ug98", "Ugo");

        Teacher teacher1 = new Teacher("bf76", "Biff");
        Teacher teacher2 = new Teacher("jm63", "James");
        Teacher teacher3 = new Teacher("mk55", "Mack");
        Teacher teacher4 = new Teacher("ch70", "Chris");

        student1.getTeachers().add(teacher1);
        student1.getTeachers().add(teacher2);
        student3.getTeachers().add(teacher4);

        studentService.createStudent(student1);
        studentService.createStudent(student2);
        studentService.createStudent(student3);

        teacherService.createTeacher(teacher3);
    }
}
