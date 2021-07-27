package com.example.employeepayroll.entity;

import com.example.employeepayroll.dto.EmployeeDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Employee {
    private int employeeId;
    private String name;
    private long salary;

    public Employee(int employeeId, EmployeeDTO employeeDTO){
        this.employeeId = employeeId;
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
    }
}
