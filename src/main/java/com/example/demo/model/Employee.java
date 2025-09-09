package com.example.demo.model;
import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empName;
    private String empAddress;
    private String email;
    private String salary;
    private String phno;
    private String department;
    private String doj;

    // Getters and Setters
}