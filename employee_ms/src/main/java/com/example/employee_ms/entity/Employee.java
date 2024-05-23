package com.example.employee_ms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @NotNull(message = "Employee ID is mandatory")
    @NotBlank(message = "Employee ID cannot be blank")
    private String employeeId;

    @NotNull(message = "Employee Name is mandatory")
    @NotBlank(message = "Employee Name cannot be blank")
    private String employeeName;

    @NotNull(message = "Employee Position is mandatory")
    @NotBlank(message = "Employee Position cannot be blank")
    private String employeePosition;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "employees")
    private List<Project> projects = new ArrayList<>();

    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
