package org.sda.hms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "department")
public class Department {


    private Integer id;

    private String depName;

    private Integer employee_it;

}
