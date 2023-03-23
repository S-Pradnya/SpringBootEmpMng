package com.example.SpringBootEmpMng.repository;

import com.example.SpringBootEmpMng.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long> {

}
