package com.kiransinh.ems.service;

import com.kiransinh.ems.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAllEmployees();
    Employee addEmployee(Employee employee);
    Optional<Employee> findEmployeeById(Long id);
    Employee updateEmployee();
    void deleteEmployee(Long id);
}
