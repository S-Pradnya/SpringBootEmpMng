package com.example.SpringBootEmpMng.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@SuppressWarnings("ALL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="resource_id")
    private Long resourceId;

    @Column(name="resource_name")
    private String resourceName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "resource")
    @JsonIgnoreProperties({"resource"})
    private Set<EmployeeResource> employeeResources;

}
