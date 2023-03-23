package com.example.SpringBootEmpMng.controller;

import com.example.SpringBootEmpMng.exception.ResourceNotFoundException;
import com.example.SpringBootEmpMng.model.Department;
import com.example.SpringBootEmpMng.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@Repository
@Controller
@CrossOrigin("*")
@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }


    @GetMapping("/dept/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not exist with id:" + id));
        return ResponseEntity.ok(department);
    }

    @PutMapping("/dept/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
        Department updateDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not exist with id: " + id));

        updateDepartment.setId(departmentDetails.getId());
        updateDepartment.setType(departmentDetails.getType());
        departmentRepository.save(updateDepartment);

        return ResponseEntity.ok(updateDepartment);
    }


    @DeleteMapping("/dept/{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department  not exist with id: " + id));

        departmentRepository.delete(department);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
