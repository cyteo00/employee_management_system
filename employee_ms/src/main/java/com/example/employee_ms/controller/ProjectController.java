package com.example.employee_ms.controller;

import com.example.employee_ms.entity.Project;
import com.example.employee_ms.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("{projectId}")
    public Project getProjectDetails(@PathVariable("projectId") String projectId) {
        return projectService.getProject(projectId);
    }

    @GetMapping
    public List<Project> getAllProjectDetails() {
        return projectService.getAllProject();
    }

    @PostMapping("create")
    public String createProjectDetails(@Valid @RequestBody Project project) {
        projectService.createProject(project);
        return "Created Successfully";
    }

    @PutMapping("update/{projectId}")
    public String updateProjectDetails(@Valid @RequestBody Project project, @PathVariable String projectId) {
        projectService.updateProject(project, projectId);
        return "Updated Successfully";
    }

    @PutMapping("{projectId}/employee/{employeeId}")
    public String assignEmployeeToProjectDetails(@PathVariable String employeeId, @PathVariable String projectId) {
        projectService.assignEmployeeToProject(employeeId, projectId);
        return "Assigned Employee Successfully";
    }

    @DeleteMapping("delete/{projectId}")
    public String deleteProjectDetails(@PathVariable("projectId") String projectId) {
        projectService.deleteProject(projectId);
        return "Deleted Successfully";
    }

    @DeleteMapping("delete")
    public String deleteAllProjectDetails() {
        projectService.deleteAllProject();
        return "Deleted Successfully";
    }
}
