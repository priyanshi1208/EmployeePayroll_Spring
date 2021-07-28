package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.entity.Employee;

import java.util.List;

public interface IEmployeePayrollService {
    List<Employee> getAllEmployeePayroll();

    Employee getEmployeePayrollById(int id);

    Employee addEmployeePayroll(EmployeeDTO employeedto);

    Employee updateEmployeePayroll(EmployeeDTO employeedto, int id);

    void deleteEmployeePayrollById(int id);

    List<Employee> getEmployeesByDepartment(String department);
}
