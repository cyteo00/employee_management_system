package com.example.employee_ms.service;

import com.example.employee_ms.entity.Employee;
import com.example.employee_ms.exception.DuplicateEntryException;
import com.example.employee_ms.exception.IdNotFoundException;
import com.example.employee_ms.repository.EmployeeRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @CacheEvict(value = "employees", allEntries = true)
    public void createEmployee(Employee employee){
        System.out.println("create");
        Optional<Employee> emp = employeeRepository.findById(employee.getEmployeeId());
        if (emp.isEmpty()){
            employeeRepository.save(employee);
        }
        else {
            throw new DuplicateEntryException("Duplicate Employee ID");
        }
    }

    @CacheEvict(value = "employees", allEntries = true)
    public void updateEmployee(Employee employee, String employeeId){
        System.out.println("update");
        Optional<Employee> emp = employeeRepository.findById(employeeId);
        if (emp.isPresent()){
            employeeRepository.save(employee);
        }
        else {
            throw new IdNotFoundException("Employee ID does not exist. Update failed");
        }
    }

    @CacheEvict(value = "employees", allEntries = true)
    public void deleteEmployee(String employeeId){
        System.out.println("delete");
        Optional<Employee> emp = employeeRepository.findById(employeeId);
        if (emp.isPresent()){
            employeeRepository.deleteById(employeeId);
        }
        else {
            throw new IdNotFoundException("Employee ID does not exist. Delete failed");
        }
    }

    @CacheEvict(value = "employees", allEntries = true)
    public void deleteAllEmployee() {
        System.out.println("delete all");
        employeeRepository.deleteAll();
    }

    @Cacheable("employees")
    public Employee getEmployee(String employeeId){
        System.out.println("get");
        Optional<Employee> emp = employeeRepository.findById(employeeId);
        if (emp.isPresent()){
            return emp.get();
        }
        else {
            throw new IdNotFoundException("Employee ID does not exist");
        }
    }

    @Cacheable("employees")
    public List<Employee> getAllEmployee(){
        System.out.println("get all");
        return employeeRepository.findAll();
    }
}
