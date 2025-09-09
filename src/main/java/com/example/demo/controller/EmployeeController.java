package com.example.demo.controller;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empcontroller")
public class EmployeeController {

    @Autowired private EmployeeRepository employeeRepo;

    @PostMapping("/saveEmp")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {
        employeeRepo.save(emp);
        return ResponseEntity.ok("Employee saved successfully");
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }
}