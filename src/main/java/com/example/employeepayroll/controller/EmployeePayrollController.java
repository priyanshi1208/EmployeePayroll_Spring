package com.example.employeepayroll.controller;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.dto.ResponseDTO;
import com.example.employeepayroll.entity.Employee;
import com.example.employeepayroll.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @GetMapping(value = {"","/","home"})
    public ResponseEntity<ResponseDTO> getEmployeePayroll(){
        List<Employee> employeeList = null;
        employeeList = employeePayrollService.getAllEmployeePayroll();
        return new ResponseEntity<>(new ResponseDTO("Getting Employee Payroll Successful",employeeList),
                HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollById(@PathVariable int id){
        Employee employee = employeePayrollService.getEmployeePayrollById(id);
        return new ResponseEntity<>(new ResponseDTO("Getting Call for ID Successful",employee)
                ,HttpStatus.FOUND);
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> addEmployeePayroll(@RequestBody EmployeeDTO employeeDto){
        Employee employee = employeePayrollService.addEmployeePayroll(employeeDto);
        return new ResponseEntity<>(new ResponseDTO("Added Employee Payroll Successfully",employee)
                ,HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(@RequestBody EmployeeDTO employeeDto,@PathVariable int id){
        Employee employee = employeePayrollService.updateEmployeePayroll(employeeDto,id);
        return new ResponseEntity<>(new ResponseDTO("Updated Employee Payroll Successfully",employee)
                ,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollById(@PathVariable int id){
        employeePayrollService.deleteEmployeePayrollById(id);
        return new ResponseEntity<>(new ResponseDTO("Deleted Employee Payroll Successfully",+id)
                ,HttpStatus.GONE);
    }
}