package com.genspark.StudentEnrollment.Service;

import com.genspark.StudentEnrollment.Entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentById(int studentId);
    Student addStudent(Student student);
    Student updateStudent(Student student);
    String deleteStudentById(int studentId);

}
