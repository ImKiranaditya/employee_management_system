package com.kiransinh.ems.service;

import com.kiransinh.ems.entity.Employee;
import com.kiransinh.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeRepository repository;

    @Override
    public List<Employee> findAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Employee updateEmployee() {
        return updateEmployee();
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
