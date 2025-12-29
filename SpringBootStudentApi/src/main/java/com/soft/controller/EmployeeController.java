

package com.soft.controller;

import com.soft.dto.*;
import com.soft.entity.*;
import com.soft.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // POST → Create
    @PostMapping
    public Employee createEmployee(@RequestBody EmployeeDTO dto) {
        return service.saveEmployee(dto);
    }

    // GET → All
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // GET → By ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    // PUT → Update full entity
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
        return service.updateEmployee(id, dto);
    }

    // PATCH → Partial update
    @PatchMapping("/{id}")
    public Employee patchEmployee(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
        return service.patchEmployee(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}