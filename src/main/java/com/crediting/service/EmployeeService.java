package com.crediting.service;

import com.crediting.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crediting.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee registerEmployee(String email, String name, String company) {
        Employee employee = new Employee();
        employee.setEmail(email);
        employee.setName(name);
        employee.setCompany(company);
        return employeeRepository.save(employee);
    }

    public double getEmployeeBalance(String email) {
        Employee employee = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return employee.getCreditBalance();
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void updateCredit(String email, double newCredit) {
        Employee employee = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setCreditBalance(newCredit);
        employeeRepository.save(employee);
    }
}
