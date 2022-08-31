package com.genspark.StudentEnrollment.Entity;

import javax.persistence.*;

@Entity
@Table(name="tbl_students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String name;
    private int age;
    private String degree;

    public Student() {
    }

    public Student(String name, int age, String degree) {
        this.name = name;
        this.age = age;
        this.degree = degree;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
