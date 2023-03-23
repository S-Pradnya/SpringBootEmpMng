package com.example.SpringBootEmpMng.controller;

import com.example.SpringBootEmpMng.exception.ResourceNotFoundException;
import com.example.SpringBootEmpMng.repository.ProjectRepository;
import com.example.SpringBootEmpMng.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @PutMapping("/project/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long projectId, @RequestBody Project projectDetails) {
        Project updateProject = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project Name not exist with id: " + projectId));
        projectRepository.save(updateProject);

        return ResponseEntity.ok(updateProject);
    }
    @DeleteMapping("/project/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable Long projectId){

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project Name not exist with id: " + projectId));

        projectRepository.delete(project);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}

