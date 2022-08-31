package com.genspark.EmployeeApplication.Service;

import com.genspark.EmployeeApplication.Dao.EmployeeDao;
import com.genspark.EmployeeApplication.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getEmployees() {
        return this.employeeDao.findAll();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        Optional<Employee> e = this.employeeDao.findById(employeeId);
        Employee employee = null;

        if (e.isPresent()) {
            employee = e.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + employeeId);
        }

        return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return this.employeeDao.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return this.employeeDao.save(employee);
    }

    @Override
    public String deleteEmployeeById(int employeeId) {
        this.employeeDao.deleteById(employeeId);
        return "Employee deleted successfully";
    }

}
