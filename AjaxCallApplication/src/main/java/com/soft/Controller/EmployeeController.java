

package com.soft.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soft.Model.EmployeeModel;
import com.soft.Service.EmployeeService;
import com.soft.Service.service;

@RestController
@RequestMapping("/empcontroller")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmp")
    public String saveEmployee(@RequestBody EmployeeModel emp) {
        employeeService.saveEmployee(emp);
        return "Employee saved successfully!";
    }


    @PostMapping("/login")
    public ResponseEntity<EmployeeModel> login(@RequestParam String email, @RequestParam String password) {
        EmployeeModel emp = service.login(email, password);
        if (emp == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(emp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(service.getAllEmployees());
    }
}