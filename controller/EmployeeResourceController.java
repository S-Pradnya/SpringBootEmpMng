package com.example.SpringBootEmpMng.controller;


import com.example.SpringBootEmpMng.exception.ResourceNotFoundException;
import com.example.SpringBootEmpMng.model.EmployeeResource;
import com.example.SpringBootEmpMng.model.Project;
import com.example.SpringBootEmpMng.repository.EmployeeResourceRepository;
import com.example.SpringBootEmpMng.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/api/empres")
public class EmployeeResourceController {

    @Autowired
    private EmployeeResourceRepository employeeResourceRepository;

    @GetMapping
    public List<EmployeeResource> getAllEmployeeResource() {
        return employeeResourceRepository.findAll();
    }

    @PostMapping
    public EmployeeResource createEmployeeResource(@RequestBody EmployeeResource employeeResource) {return employeeResourceRepository.save(employeeResource);
    }

    @PutMapping("/empres/{id}")
    public ResponseEntity<EmployeeResource> updateEmployeeResource(@PathVariable Long ID, @RequestBody EmployeeResource employeeResourceDetails) {
        EmployeeResource updateEmployeeResource = employeeResourceRepository.findById(ID)
                .orElseThrow(() -> new ResourceNotFoundException("EmployeeResource Name not exist with id: " + ID));
        employeeResourceRepository.save(updateEmployeeResource);

        return ResponseEntity.ok(updateEmployeeResource);
    }

    @DeleteMapping("/empres/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeResource(@PathVariable Long ID){

        EmployeeResource employeeResource = employeeResourceRepository.findById(ID)
                .orElseThrow(() -> new ResourceNotFoundException("EmployeeResource Name not exist with id: " + ID));

        employeeResourceRepository.delete(employeeResource);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
