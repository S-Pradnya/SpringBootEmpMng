package com.example.SpringBootEmpMng.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;


@Entity
@SuppressWarnings("ALL")
@Table(name = "employee_project")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ep_id")
    private Long Id;

    @Column(name = "ep_employee_id")
    private Long epEmployeeId;

    @Column(name = "ep_project_id")
    private Long epProjectId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ep_employee_id", insertable = false, updatable = false)
    @JsonIgnoreProperties({"employeeProject"})
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ep_project_id", insertable = false, updatable = false)
    @JsonIgnoreProperties({"employeeProject"})
    private Project project;

}

