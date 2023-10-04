package com.geekster.assignment.EmployeeAddress.Service;

import com.geekster.assignment.EmployeeAddress.Model.Employee;
import com.geekster.assignment.EmployeeAddress.Repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final IEmployeeRepo employeeRepository;

    @Autowired
    public EmployeeService(IEmployeeRepo employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

    public String createEmployee(Employee employee) {
         employeeRepository.save(employee);
         return "Employee Added";
    }

    public String createListOfEmployees(List<Employee> employeeList) {
         employeeRepository.saveAll(employeeList);
         return "Added list of employees";
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setLastName(updatedEmployee.getLastName());
            existingEmployee.setAddress(updatedEmployee.getAddress());
            return employeeRepository.save(existingEmployee);
        } else {
            return null; // Employee with the given ID not found
        }
    }


    public String  deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
        return "Employee is removed!";
    }
}
