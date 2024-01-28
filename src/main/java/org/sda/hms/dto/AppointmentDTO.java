package org.sda.hms.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO {

    private Integer id;
    private LocalDateTime appointmentDate;
    private String prescription;
    private String patientNotes;
    private UserDTO patientId;
    private EmployeeDto doctorId;
    private ExaminationDTO examinationId;


}
