package com.example.employeepayroll.entity;

import com.example.employeepayroll.dto.EmployeeDTO;

public class Employee {
    private int employeeId;
    private String name;
    private long salary;

    public Employee(){
    }

    public Employee(int employeeId, EmployeeDTO employeeDTO){
        this.employeeId = employeeId;
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}