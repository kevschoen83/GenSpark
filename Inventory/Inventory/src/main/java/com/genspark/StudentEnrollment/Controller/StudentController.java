package com.genspark.StudentEnrollment.Controller;

import com.genspark.StudentEnrollment.Entity.Student;
import com.genspark.StudentEnrollment.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home() {
        return "<HTML><H1>Welcome to Student Enrollment Application</H1></HTML>";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable String studentId) {
        return studentService.getStudentById(Integer.parseInt(studentId));
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return this.studentService.updateStudent(student);
    }

    public String deleteStudent(@PathVariable String studentId) {
        return this.studentService.deleteStudentById(Integer.parseInt(studentId));
    }

}
