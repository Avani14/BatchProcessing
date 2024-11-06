package com.batch_processing.Employee.config;

import com.batch_processing.Employee.model.Employee;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

public class CustomEmployeeProcessor implements ItemProcessor<Employee, Employee> {
    @Override
    public Employee process(Employee item) throws Exception {

        double bonus = item.getBonus()/100;
        BigInteger newSalary  =  item.getSalary().multiply(BigInteger.valueOf((long) bonus));
        item.setNewSalary(newSalary);
        return item;
    }
}
