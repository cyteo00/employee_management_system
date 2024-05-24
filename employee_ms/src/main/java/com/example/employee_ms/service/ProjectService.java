package com.example.employee_ms.service;

import com.example.employee_ms.entity.Employee;
import com.example.employee_ms.entity.Project;
import com.example.employee_ms.exception.DuplicateEntryException;
import com.example.employee_ms.exception.IdNotFoundException;
import com.example.employee_ms.repository.EmployeeRepository;
import com.example.employee_ms.repository.ProjectRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    public ProjectService(ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @CacheEvict(value = "projects", allEntries = true)
    public void createProject(Project project) {
        Optional<Project> proj = projectRepository.findById(project.getProjectId());
        if (proj.isEmpty()) {
            projectRepository.save(project);
        } else {
            throw new DuplicateEntryException("Duplicate Project ID");
        }
    }

    @CacheEvict(value = "projects", allEntries = true)
    public void updateProject(Project project, String projectId) {
        Optional<Project> proj = projectRepository.findById(projectId);
        if (proj.isPresent()) {
            projectRepository.save(project);
        } else {
            throw new IdNotFoundException("Project ID does not exist. Update failed");
        }
    }

    @CacheEvict(value = "projects", allEntries = true)
    public void assignEmployeeToProject(String employeeId, String projectId) {
        Optional<Employee> emp = employeeRepository.findById(employeeId);
        Optional<Project> proj = projectRepository.findById(projectId);
        if (emp.isPresent() && proj.isPresent()) {
            proj.get().assignEmployee(emp.get());
            projectRepository.save(proj.get());
        } else {
            throw new IdNotFoundException("Project ID does not exist. Update failed");
        }
    }

    @CacheEvict(value = "projects", allEntries = true)
    public void deleteProject(String projectId) {
        Optional<Project> proj = projectRepository.findById(projectId);
        if (proj.isPresent()) {
            projectRepository.deleteById(projectId);
        } else {
            throw new IdNotFoundException("Project ID does not exist. Delete failed");
        }
    }

    @CacheEvict(value = "projects", allEntries = true)
    public void deleteAllProject() {
        System.out.println("delete all");
        projectRepository.deleteAll();
    }

    @Cacheable("projects")
    public Project getProject(String projectId) {
        Optional<Project> proj = projectRepository.findById(projectId);
        if (proj.isPresent()) {
            return proj.get();
        } else {
            throw new IdNotFoundException("Project ID does not exist");
        }
    }

    @Cacheable("projects")
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }
}
