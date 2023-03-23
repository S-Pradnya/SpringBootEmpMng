package com.example.SpringBootEmpMng.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@SuppressWarnings("ALL")
@Getter
@Setter
@Data
@Table(name="employee_resource")
public class EmployeeResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="er_id")
    private Long ID;

    @Column(name = "er_employee_id")
    private Long erEmployeeId;

    @Column(name = "er_project_id")
    private Long erProjectId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "er_employee_id", insertable = false, updatable = false)
    @JsonIgnoreProperties({"employeeResources"})
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "er_project_id", insertable = false, updatable = false)
    @JsonIgnoreProperties({"employeeResources"})
    private Resource resource;
}
