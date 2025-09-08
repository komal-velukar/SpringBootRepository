package com.soft.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soft.Model.EmployeeModel;
import com.soft.Model.UserModel;
import com.soft.Service.EmployeeService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private EmployeeService userservice;
	
	
	@PostMapping("/saveuser")
	public UserModel  saveUserDetils (@RequestBody UserModel  userModel)
	{
		UserModel saveUser = userservice.saveUserFromService(userModel);
		
		return saveUser;
	}
}
