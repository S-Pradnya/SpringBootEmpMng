package com.example.SpringBootEmpMng.repository;

import com.example.SpringBootEmpMng.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}