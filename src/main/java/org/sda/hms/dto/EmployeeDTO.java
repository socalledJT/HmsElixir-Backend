package org.sda.hms.dto;

import lombok.Data;
import org.sda.hms.entities.Department;
import org.sda.hms.entities.User;
@Data
public class EmployeeDTO {

        private Integer id;
        private UserDTO userId;
        private DepartmentDTO departmentId;

    }
