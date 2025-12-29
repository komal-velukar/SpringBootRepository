package com.soft.service;



import com.soft.dto.EmployeeDTO;
import com.soft.entity.Employee;
import com.soft.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Create
    public Employee saveEmployee(EmployeeDTO dto) {
        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setDepartment(dto.getDepartment());
        emp.setSalary(dto.getSalary());
        return repository.save(emp);
    }

    // Read All
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Read by ID
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    // Update (PUT → full replace)
    public Employee updateEmployee(Long id, EmployeeDTO dto) {
        Employee emp = getEmployeeById(id);
        emp.setName(dto.getName());
        emp.setDepartment(dto.getDepartment());
        emp.setSalary(dto.getSalary());
        return repository.save(emp);
    }

    // Partial Update (PATCH → some fields only)
    public Employee patchEmployee(Long id, EmployeeDTO dto) {
        Employee emp = getEmployeeById(id);
        if (dto.getName() != null) emp.setName(dto.getName());
        if (dto.getDepartment() != null) emp.setDepartment(dto.getDepartment());
        if (dto.getSalary() != null) emp.setSalary(dto.getSalary());
        return repository.save(emp);
    }

    // Delete
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}