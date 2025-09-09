package com.soft.service;
import com.soft.model.EmployeeModel;
import com.soft.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeModel saveEmployee(EmployeeModel employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeModel getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeModel updateEmployee(int id, EmployeeModel updatedEmployee) {
        Optional<EmployeeModel> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            EmployeeModel employee = existingEmployee.get();
            employee.setName(updatedEmployee.getName());
            employee.setAddress(updatedEmployee.getAddress());
            employee.setSalary(updatedEmployee.getSalary());
            employee.setJoiningDate(updatedEmployee.getJoiningDate());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setPhone(updatedEmployee.getPhone());
            employee.setEmail(updatedEmployee.getEmail());
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeModel findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<EmployeeModel> findBySalaryGreaterThan10000() {
        return employeeRepository.findBySalaryGreaterThan10000();
    }

    @Override
    public long countEmployees() {
        return employeeRepository.countEmployees();
    }

    @Override
    public List<EmployeeModel> findByNameStartingWithB() {
        return employeeRepository.findByNameStartingWithB();
    }

    @Override
    public List<EmployeeModel> findByJoiningBefore2003() {
        return employeeRepository.findByJoiningBefore2003();
    }
}