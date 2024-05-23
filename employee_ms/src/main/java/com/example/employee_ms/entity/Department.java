package com.example.employee_ms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name="department")
public class Department {
    @Id
    @NotNull(message = "Department ID is mandatory")
    @NotBlank(message = "Department ID cannot be blank")
    private String departmentId;

    @NotNull(message = "Department Name is mandatory")
    @NotBlank(message = "Department Name cannot be blank")
    private String departmentName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> employees;

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
