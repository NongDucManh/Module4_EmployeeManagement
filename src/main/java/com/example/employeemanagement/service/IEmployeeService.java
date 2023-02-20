package com.example.employeemanagement.service;

import java.util.List;

import com.example.employeemanagement.model.Employee;


public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(int id);

    void update(int id, Employee employee);

    void remove(int id);
}