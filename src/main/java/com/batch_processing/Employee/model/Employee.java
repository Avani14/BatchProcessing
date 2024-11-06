package com.batch_processing.Employee.model;

import jakarta.persistence.*;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "gender")
    private String gender;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date startDate;

    @Column(name = "last_login")
    @DateTimeFormat(pattern = "hh:mm a")
    private Date lastLogin;

    @Column(name = "salary")
    private BigInteger salary;

    @Column(name = "bonus")
    private double bonus;

    @Column(name = "is_senior_management")
    private boolean isSeniorManagement;

    @Column(name = "team")
    private String team;

    @Column(name = "new_salary")
    private BigInteger newSalary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public boolean isSeniorManagement() {
        return isSeniorManagement;
    }

    public void setSeniorManagement(boolean seniorManagement) {
        isSeniorManagement = seniorManagement;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public BigInteger getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(BigInteger newSalary) {
        this.newSalary = newSalary;
    }
}
