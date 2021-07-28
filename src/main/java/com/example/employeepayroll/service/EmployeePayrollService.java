package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.entity.Employee;
import com.example.employeepayroll.exception.EmployeePayrollException;
import com.example.employeepayroll.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{
    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    //private List<Employee> employeeList = new ArrayList<>();
    @Override
    public List<Employee> getAllEmployeePayroll() {
        return employeePayrollRepository.findAll();
    }

    @Override
    public Employee getEmployeePayrollById(int id) {
        return employeePayrollRepository.findById(id).orElseThrow(()->new EmployeePayrollException(
                "Employee with employeeId"+id+"does not exists!"
        ));
    }

    @Override
    public Employee addEmployeePayroll(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        log.debug("Emp Data",employee.toString());
        return employeePayrollRepository.save(employee);
    }

    @Override
    public Employee updateEmployeePayroll(EmployeeDTO employeeDTO, int id) {
        Employee employee = this.getEmployeePayrollById(id);
        employee.updateEmployeePayrollData(employeeDTO);
        return employeePayrollRepository.save(employee);
    }

    @Override
    public void deleteEmployeePayrollById(int id) {
        Employee employee=this.getEmployeePayrollById(id);
        employeePayrollRepository.delete(employee);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeePayrollRepository.findEmployeesByDepartment(department);
    }
}