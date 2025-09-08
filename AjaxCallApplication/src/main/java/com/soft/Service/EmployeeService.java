

package com.soft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.Model.EmployeeModel;
import com.soft.Model.UserModel;
import com.soft.Repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public EmployeeModel saveEmployee(EmployeeModel emp) {
        return repo.save(emp);
    }

    public EmployeeModel login(String email, String password) {
        return repo.findByEmailAndPassword(email, password);
    }

    public List<EmployeeModel> getAllEmployees() {
        return repo.findAll();
    }

	public UserModel saveUserFromService(UserModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}
}