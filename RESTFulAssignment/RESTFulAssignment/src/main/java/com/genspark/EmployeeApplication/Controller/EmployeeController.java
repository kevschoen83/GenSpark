package com.genspark.EmployeeApplication.Controller;

import com.genspark.EmployeeApplication.Entity.Employee;
import com.genspark.EmployeeApplication.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String home() {
        return "<HTML><H1>Welcome to Employee Application</H1></HTML>";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId) {
        return this.employeeService.getEmployeeById(Integer.parseInt(employeeId));
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return this.employeeService.addEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return this.employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        return this.employeeService.deleteEmployeeById(Integer.parseInt(employeeId));
    }

}
