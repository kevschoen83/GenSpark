package com.genspark.EmployeeApplication.Service;

import com.genspark.EmployeeApplication.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();
    Employee getEmployeeById(int employeeId);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    String deleteEmployeeById(int employeeId);

}
