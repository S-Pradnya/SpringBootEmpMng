package com.example.SpringBootEmpMng.service;

import com.example.SpringBootEmpMng.model.Employee;
import com.example.SpringBootEmpMng.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;


@SuppressWarnings("ALL")
@Service
public class EmployeeService implements EmployeeServiceClass {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Stream<Employee> findAll(int pageNo, int pageSize,String sortBy) {

        Pageable pageable = PageRequest.of(0, 5,Sort.by("createdDate").descending());
        Page<Employee> pagedResult = employeeRepository.findAll(pageable);
        return pagedResult.stream();



    }
}
