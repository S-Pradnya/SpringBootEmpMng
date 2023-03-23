package com.example.SpringBootEmpMng.service;

import com.example.SpringBootEmpMng.model.Employee;

import java.util.stream.Stream;

@SuppressWarnings("ALL")
public interface EmployeeServiceClass {

    Stream<Employee> findAll(int pageNo, int pageSize);

}
