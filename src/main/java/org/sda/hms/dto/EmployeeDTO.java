package org.sda.hms.dto;

import lombok.Data;
import org.sda.hms.entities.Department;
import org.sda.hms.entities.User;

@Data
public class EmployeeDTO {
    private Integer id;
    private User userId;
    private Department departmentId;
}