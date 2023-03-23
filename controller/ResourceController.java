package com.example.SpringBootEmpMng.controller;

import com.example.SpringBootEmpMng.exception.ResourceNotFoundException;
import com.example.SpringBootEmpMng.model.Resource;
import com.example.SpringBootEmpMng.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/api/resource")
public class ResourceController {

    @Autowired
    private ResourceRepository resourceRepository;

    @GetMapping
    public List<Resource> getAllResource() {
        return resourceRepository.findAll();
    }

    @PostMapping
    public Resource createResource(@RequestBody Resource resource) {
        return resourceRepository.save(resource);
    }

    @PutMapping("/res/{id}")
    public ResponseEntity<Resource> updateResource(@PathVariable Long resourceId, @RequestBody Resource resourceDetails) {
        Resource updateResource = resourceRepository.findById(resourceId)
                .orElseThrow(() -> new ResourceNotFoundException("Resource Name not exist with id: " + resourceId));
        resourceRepository.save(updateResource);

        return ResponseEntity.ok(updateResource);
    }
    @DeleteMapping("/res/{id}")
    public ResponseEntity<HttpStatus> deleteResource(@PathVariable Long resourceId){

        Resource resource = resourceRepository.findById(resourceId)
                .orElseThrow(() -> new ResourceNotFoundException("Resource Name not exist with id: " + resourceId));

        resourceRepository.delete(resource);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
