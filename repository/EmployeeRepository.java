package com.example.SpringBootEmpMng.repository;

import com.example.SpringBootEmpMng.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {


}
