package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.entity.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    private List<Employee> employeeList = new ArrayList<>();
    @Override
    public List<Employee> getAllEmployeePayroll() {
        return employeeList;
    }

    @Override
    public Employee getEmployeePayrollById(int id) {
        return employeeList.get(id-1);
    }

    @Override
    public Employee addEmployeePayroll(EmployeeDTO employeeDTO) {
        Employee employee = null;
        employee = new Employee(1,employeeDTO);
        this.employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee updateEmployeePayroll(EmployeeDTO employeeDTO, int id) {
        Employee employee = this.getEmployeePayrollById(id);
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        this.employeeList.set(id-1,employee);
        return employee;
    }

    @Override
    public void deleteEmployeePayrollById(int id) {
        employeeList.remove(id - 1);
    }
}