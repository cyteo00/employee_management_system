package com.example.employee_ms.controller;

import com.example.employee_ms.entity.Employee;
import com.example.employee_ms.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("{employeeId}")
    public Employee getEmployeeDetails(@PathVariable("employeeId") String employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping
    public List<Employee> getAllEmployeeDetails(){
        return employeeService.getAllEmployee();
    }

    @PostMapping("create")
    public String createEmployeeDetails(@Valid @RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return "Created Successfully";
    }

    @PutMapping("update")
    public String updateEmployeeDetails(@Valid @RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return "Updated Successfully";
    }

    @DeleteMapping("delete/{employeeId}")
    public String deleteEmployeeDetails(@PathVariable("employeeId") String employeeId){
        employeeService.deleteEmployee(employeeId);
        return "Deleted Successfully";
    }
}
