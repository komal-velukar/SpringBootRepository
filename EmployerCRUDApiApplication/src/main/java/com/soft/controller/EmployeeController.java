package com.soft.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.soft.model.EmployeeModel;
import com.soft.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public EmployeeModel saveEmployeeDetails(@RequestBody EmployeeModel employeeModel) {
        return employeeService.saveEmployee(employeeModel);
    }

    @DeleteMapping("/delete")
    public int deleteEmployeeById(@RequestParam int employeeId) {
        return employeeService.deleteEmployeeByIdFromService(employeeId);
    }

    @PutMapping("/update/{employeeId}")
    public String updateEmployeeById(@PathVariable int employeeId, @RequestBody EmployeeModel employeeModel) {
        return employeeService.updateByIdFromService(employeeId, employeeModel);
    }

    @GetMapping("/all")
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.getAllFromService();
    }

    @GetMapping("/findByName")
    public EmployeeModel findEmployeeByName(@RequestParam String name) {
        return employeeService.findEmployeeByNameFromService(name);
    }
}