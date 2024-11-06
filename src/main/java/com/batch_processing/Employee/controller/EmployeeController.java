package com.batch_processing.Employee.controller;


import com.batch_processing.Employee.model.Employee;
import com.batch_processing.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping(value = "/getEmployees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return ResponseEntity.ok().body(employeeService.getEmployees());
    }
}
