package com.spring.PracticeProject.repo;

import com.spring.PracticeProject.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

public class StudentRepo {

    public static List<Student> getAllStudent() {

        Student s = new Student(101, "Kajal", "pune", 90);
        Student s1 = new Student(102, "Om", "Pune", 60);
        Student s2 = new Student(103, "John", "Mumbai", 87);
        Student s3 = new Student(104, "Priya", "Mumbai", 75);
        Student s4 = new Student(105, "Ankit", "Delhi", 82);
        Student s5 = new Student(106, "Sara", "Pune", 91);
        Student s6 = new Student(107, "Vikram", "Delhi", 68);
        Student s7 = new Student(108, "Neha", "Mumbai", 95);
        Student s8 = new Student(109, "Aman", "Bangalore", 73);
        Student s9 = new Student(110, "Meena", "Pune", 88);
        Student s10 = new Student(111, "Ravi", "Hyderabad", 79);

        List<Student> stu = Arrays.asList(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10);
        return stu;

    }

}
