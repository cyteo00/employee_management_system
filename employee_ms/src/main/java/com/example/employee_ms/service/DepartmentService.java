package com.example.employee_ms.service;

import com.example.employee_ms.entity.Department;
import com.example.employee_ms.exception.DuplicateEntryException;
import com.example.employee_ms.exception.IdNotFoundException;
import com.example.employee_ms.repository.DepartmentRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @CacheEvict(value = "departments", allEntries = true)
    public void createDepartment(Department department){
        Optional<Department> dept = departmentRepository.findById(department.getDepartmentId());
        if (dept.isEmpty()){
            departmentRepository.save(department);
        }
        else {
            throw new DuplicateEntryException("Duplicate Department ID");
        }
    }

    @CacheEvict(value = "departments", allEntries = true)
    public void updateDepartment(Department department, String departmentId){
        Optional<Department> dept = departmentRepository.findById(departmentId);
        if (dept.isPresent()){
            departmentRepository.save(department);
        }
        else {
            throw new IdNotFoundException("Department ID does not exist. Update failed");
        }
    }

    @CacheEvict(value = "departments", allEntries = true)
    public void deleteDepartment(String departmentId){
        Optional<Department> dept = departmentRepository.findById(departmentId);
        if (dept.isPresent()){
            departmentRepository.deleteById(departmentId);
        }
        else {
            throw new IdNotFoundException("Department ID does not exist. Delete failed");
        }
    }

    @CacheEvict(value = "departments", allEntries = true)
    public void deleteAllDepartment() {
        departmentRepository.deleteAll();
    }

    @Cacheable("departments")
    public Department getDepartment(String departmentId){
        Optional<Department> dept = departmentRepository.findById(departmentId);
        if (dept.isPresent()){
            return dept.get();
        }
        else {
            throw new IdNotFoundException("Department ID does not exist");
        }
    }

    @Cacheable("departments")
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }
}
