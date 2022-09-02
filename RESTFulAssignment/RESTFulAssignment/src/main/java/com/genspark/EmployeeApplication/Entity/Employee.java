package com.genspark.EmployeeApplication.Entity;

import org.hibernate.annotations.ValueGenerationType;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name="tbl_employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;

    private String name;
    private String phoneNumber;
    private String city;
    private String state;

    public Employee() {
    }

    public Employee(String name, String phoneNumber, String city, String state) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
