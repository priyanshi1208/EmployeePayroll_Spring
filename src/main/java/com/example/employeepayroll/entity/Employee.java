package com.example.employeepayroll.entity;

import com.example.employeepayroll.dto.EmployeeDTO;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee_payroll")
public @Data class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="employee_Id")
    private int employeeId;
    @Column(name = "name")
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name="employee_department",joinColumns = @JoinColumn(name = "id"))
    @Column(name="department")
    private List<String> departments;

    public Employee(EmployeeDTO employeeDTO){
      this.updateEmployeePayrollData(employeeDTO);
    }
    public void updateEmployeePayrollData(EmployeeDTO employeeDTO){
        this.name = employeeDTO.name;
        this.salary = employeeDTO.salary;
        this.gender=employeeDTO.gender;
        this.startDate=employeeDTO.startDate;
        this.note=employeeDTO.note;
        this.profilePic=employeeDTO.profilePic;
        this.departments=employeeDTO.department;
    }
}
