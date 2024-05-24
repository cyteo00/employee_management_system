package com.example.employee_ms.controller;

import com.example.employee_ms.entity.Department;
import com.example.employee_ms.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("{departmentId}")
    public Department getDepartmentDetails(@PathVariable("departmentId") String departmentId){
        return departmentService.getDepartment(departmentId);
    }

    @GetMapping
    public List<Department> getAllDepartmentDetails(){
        return departmentService.getAllDepartment();
    }

    @PostMapping("create")
    public String createDepartmentDetails(@Valid @RequestBody Department department){
        departmentService.createDepartment(department);
        return "Created Successfully";
    }

    @PutMapping("update/{departmentId}")
    public String updateDepartmentDetails(@Valid @RequestBody Department department, @PathVariable String departmentId){
        departmentService.updateDepartment(department, departmentId);
        return "Updated Successfully";
    }

    @DeleteMapping("delete/{departmentId}")
    public String deleteDepartmentDetails(@PathVariable("departmentId") String departmentId){
        departmentService.deleteDepartment(departmentId);
        return "Deleted Successfully";
    }

    @DeleteMapping("delete")
    public String deleteAllDepartmentDetails(){
        departmentService.deleteAllDepartment();
        return "Deleted Successfully";
    }
}
