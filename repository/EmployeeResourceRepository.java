package com.example.SpringBootEmpMng.repository;

import com.example.SpringBootEmpMng.model.EmployeeResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeResourceRepository extends JpaRepository<EmployeeResource,Long> {
}
