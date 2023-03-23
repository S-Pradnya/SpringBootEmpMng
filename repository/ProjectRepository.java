package com.example.SpringBootEmpMng.repository;

import com.example.SpringBootEmpMng.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
