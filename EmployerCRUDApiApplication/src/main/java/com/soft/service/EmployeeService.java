package com.soft.service;

import com.soft.model.EmployeeModel;
import java.util.List;

public interface EmployeeService {
    EmployeeModel saveEmployee(EmployeeModel employee);
    EmployeeModel getEmployeeById(int id);
    List<EmployeeModel> getAllEmployees();
    EmployeeModel updateEmployee(int id, EmployeeModel employee);
    void deleteEmployee(int id);
    EmployeeModel findByName(String name);
    List<EmployeeModel> findBySalaryGreaterThan10000();
    long countEmployees();
    List<EmployeeModel> findByNameStartingWithB();
    List<EmployeeModel> findByJoiningBefore2003();
}