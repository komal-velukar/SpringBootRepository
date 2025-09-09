package com.soft.model;



import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;
    private double salary;
    
    @Temporal(TemporalType.DATE)
    private Date joiningDate;
    
    private String department;
    private String phone;
    private String email;

    // Constructors
    public EmployeeModel() {
    }

    public EmployeeModel(String name, String address, double salary, Date joiningDate, String department, String phone, String email) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.department = department;
        this.phone = phone;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary
				+ ", joiningDate=" + joiningDate + ", department=" + department + ", phone=" + phone + ", email="
				+ email + "]";
	}
    
}