package com.batch_processing.Employee.config;

import com.batch_processing.Employee.model.Employee;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class EmployeeFieldSetMapper implements FieldSetMapper<Employee> {


    @Override
    public Employee mapFieldSet(FieldSet fieldSet) {
        Employee employee = new Employee();
        employee.setFirstName(fieldSet.readString("FirstName")); // CSV header
        employee.setGender(fieldSet.readString("Gender"));       // CSV header
        try {
            employee.setLastLogin(new SimpleDateFormat("hh:mm a").parse(fieldSet.readString("lastLogin")));
            employee.setStartDate(new SimpleDateFormat("MM-dd-yyyy").parse(fieldSet.readString("startDate")));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        employee.setSalary(BigInteger.valueOf(fieldSet.readLong("Salary")));       // CSV header
        employee.setBonus(fieldSet.readDouble("Bonus%")); // CSV header
        employee.setSeniorManagement(fieldSet.readBoolean("SeniorManagement")); // CSV header
        employee.setTeam(fieldSet.readString("Team"));           // CSV header
        employee.setId(fieldSet.readLong("Id"));               // CSV header
        return employee;
    }
}