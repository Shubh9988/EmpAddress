package com.geekster.assignment.EmployeeAddress.Repository;


import com.geekster.assignment.EmployeeAddress.Model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Long> {

}