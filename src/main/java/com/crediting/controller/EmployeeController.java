package com.crediting.controller;

import com.crediting.dto.*;
import com.crediting.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.crediting.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerEmployee(@RequestBody EmployeeRequest request) {
        Employee employee = employeeService.registerEmployee(request.getEmail(), request.getName(), request.getCompany());
        return ResponseEntity.ok(new RegisterResponse(true, employee.getCreditBalance()));
    }

    @PostMapping("/balance")
    public ResponseEntity<?> checkBalance(@RequestBody EmployeeRequest request) {
        double balance = employeeService.getEmployeeBalance(request.getEmail());
        return ResponseEntity.ok(new BalanceResponse(balance));
    }

    @GetMapping("/list")
    public ResponseEntity<?> listEmployees() {
        System.out.println("Received request for employee list");
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/update-credit")
    public ResponseEntity<?> updateCredit(@RequestBody UpdateCreditRequest request) {
        employeeService.updateCredit(request.getEmail(), request.getCredit());
        return ResponseEntity.ok(new UpdateCreditResponse(true, request.getCredit()));
    }
}
