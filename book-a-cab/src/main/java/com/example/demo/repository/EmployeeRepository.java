package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

}
