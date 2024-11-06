package com.batch_processing.Employee.service;

import com.batch_processing.Employee.model.Employee;
import com.batch_processing.Employee.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

}
