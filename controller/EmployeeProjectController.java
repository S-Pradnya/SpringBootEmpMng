package com.example.SpringBootEmpMng.controller;

import com.example.SpringBootEmpMng.exception.ResourceNotFoundException;
import com.example.SpringBootEmpMng.model.EmployeeProject;
import com.example.SpringBootEmpMng.repository.EmployeeProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp1")
public class EmployeeProjectController {


    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    @GetMapping
    public List<EmployeeProject> getAllEmployeeProject() {
        return employeeProjectRepository.findAll();
    }
    @PostMapping
    public EmployeeProject createEmployeeProject(@RequestBody EmployeeProject employeeProject) {
        return employeeProjectRepository.save(employeeProject);
    }

    @PutMapping("/emp1/{id}")
    public ResponseEntity<EmployeeProject> updateEmployeeProject(@PathVariable Long Id, @RequestBody EmployeeProject employeeProjectDetails) {
        EmployeeProject updateEmployeeProject = employeeProjectRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Project Name not exist with id: " + Id));
        employeeProjectRepository.save(updateEmployeeProject);

        return ResponseEntity.ok(updateEmployeeProject);
    }
    @DeleteMapping("/emp1/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeProject(@PathVariable Long Id){

        EmployeeProject employeeProject = employeeProjectRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Project Name not exist with id: " + Id));

        employeeProjectRepository.delete(employeeProject);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
