package com.spring.PracticeProject.controller;

import com.spring.PracticeProject.entity.Student;
import com.spring.PracticeProject.repo.StudentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Name;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/start")
public class MyController {


    @GetMapping("/getStr")
    public ResponseEntity<List<String>> getStr() {
        List<String> str = Arrays.asList("John", "Alice", "Bob", "Tonny");
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

    @GetMapping("/getCase")
    public ResponseEntity<List<String>> getCase() {
        List<String> s1 = Arrays.asList("John", "Alice", "Bob", "Tonny");
        List<String> name = s1.stream().map(String::toLowerCase).toList();

        return new ResponseEntity<>(name, HttpStatus.OK);
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> s = StudentRepo.getAllStudent();
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

// get list of student by id

    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") int id) {

        List<Student> stu = StudentRepo.getAllStudent();

        for (Student s1 : stu) {

            if (id == s1.getId()) {
                return new ResponseEntity<>(s1, HttpStatus.OK);
            }
        }
        Student s1 = new Student();
        return new ResponseEntity<>(s1, HttpStatus.NOT_FOUND);
    }

    // get Student by Name

    @GetMapping("/getByName/{name}")
    public ResponseEntity<Student> getByName(@PathVariable("name") String name) {
        List<Student> s = StudentRepo.getAllStudent();

        for (Student s1 : s) {

            if (name.equals(s1.getName())) {
                return new ResponseEntity<>(s1, HttpStatus.OK);
            }

        }
        Student s2 = new Student();
        return new ResponseEntity<>(s2, HttpStatus.NOT_FOUND);
    }

    // get student by city
    // get list of student by city

    @GetMapping("/getByCity/{city}")
    public ResponseEntity<List<Student>> getByCity(@PathVariable("city") String city) {

        List<Student> stu = StudentRepo.getAllStudent();

        List<Student> sortedList = new ArrayList<>();
        for (Student s : stu) {

            if (city.equalsIgnoreCase(s.getCity())) {
                sortedList.add(s);
            }
        }
        return new ResponseEntity<>(sortedList, HttpStatus.OK);
    }


    @GetMapping("/getStudent")
    public ResponseEntity<List<Student>> getStudent(@RequestParam(required = false) String city) {

        System.err.println("City is: " + city);
        List<Student> s = StudentRepo.getAllStudent();

        List<Student> sortedList = new ArrayList<>();

        if (city != null) {

            for (Student s1 : s) {
                if (city.equalsIgnoreCase(s1.getCity())) {
                    sortedList.add(s1);
                }
            }
            return new ResponseEntity<>(sortedList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(s, HttpStatus.OK);
        }
    }

    @GetMapping("/getName")
    public ResponseEntity<List<Student>> getStudentName(@RequestParam(required = false) String name) {

        System.err.println("Student name: " + name);
        List<Student> s = StudentRepo.getAllStudent();

        List<Student> sorted = new ArrayList<>();

        if (name != null) {
            for (Student stu : s) {
                if (name.equalsIgnoreCase(stu.getName())) {
                    sorted.add(stu);
                }
            }
            return new ResponseEntity<>(sorted, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(s, HttpStatus.OK);
        }

    }

    // get one student data
    // this @RequestBody annotation will help to show our data from potman to application(console)
    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student stu) {

        System.out.println("Student Details: " + stu);

        return new ResponseEntity<>("Data Save Successfully", HttpStatus.CREATED);
    }

// get List of student

    @PostMapping("/getStudent")
    public ResponseEntity<String> getAllStudent(@RequestBody List<Student> studentList) {

        System.out.println("Student list: " + studentList);
        for (Student s : studentList) {
            System.out.println(s);
        }
        return new ResponseEntity<>("Student List save successfully", HttpStatus.CREATED);
    }
}
