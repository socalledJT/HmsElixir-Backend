package org.sda.hms.dto;


import lombok.Data;
import org.sda.hms.entities.Employee;

@Data
public class DepartmentDTO {
    private Integer id;
    private String depName;

}