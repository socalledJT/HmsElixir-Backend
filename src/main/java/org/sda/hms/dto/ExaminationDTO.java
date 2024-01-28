package org.sda.hms.dto;

import lombok.Data;
import org.sda.hms.entities.Employee;
import org.sda.hms.entities.User;

import java.time.LocalDateTime;

@Data
public class ExaminationDTO {
    private Integer id;
    private LocalDateTime examinationDate;
    private String examinationNotes;
    private UserDTO userId;
    private EmployeeDTO employeeId;

  }