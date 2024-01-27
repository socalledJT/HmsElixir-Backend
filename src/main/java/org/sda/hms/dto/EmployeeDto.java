package org.sda.hms.dto;

import lombok.Data;
import org.sda.hms.entities.Department;
@Data
public class EmployeeDto {
    private Integer id;
    private UserDTO userId;
}
