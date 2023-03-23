package com.example.SpringBootEmpMng.repository;

import com.example.SpringBootEmpMng.model.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Long> {
}
