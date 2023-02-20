package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EmployeeService implements IEmployeeService {
    private static final Map<Integer, Employee> employees;

    static {

        employees = new HashMap<>();
        employees.put(1, new Employee(1, "cuong", "cuong@gmail.com", "Hanoi"));
        employees.put(2, new Employee(2, "thang", "thang@gmail.com", "BacNinh"));

    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public void save(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    @Override
    public Employee findById(int id) {
        return employees.get(id);
    }

    @Override
    public void update(int id, Employee employee) {
        employees.put(id, employee);

    }

    @Override
    public void remove(int id) {
        employees.remove(id);
    }
}