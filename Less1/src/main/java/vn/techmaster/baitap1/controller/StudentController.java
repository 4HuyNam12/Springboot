package vn.techmaster.baitap1.controller;

import org.springframework.web.bind.annotation.*;
import vn.techmaster.baitap1.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private List<Student> students;
    public StudentController() {
        students = new ArrayList<>();
        students.add(new Student("1","Nguyen Van A","VanA@gmail.com"));
        students.add(new Student("2","Nguyen Van B","VanB@gmail.com"));
        students.add(new Student("3","Nguyen Van C","VanC@gmail.com"));
    }
    @GetMapping
    public List<Student> students() {
        return students;
    }
    @PostMapping
    public Student createNewStudent(@RequestBody Student student) {
        Student newStudent = new Student(student.getId(),student.getFullName(),student.getEmail());
        students.add(newStudent);
        return newStudent;
    }

}
