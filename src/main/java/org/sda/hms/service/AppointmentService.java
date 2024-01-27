package org.sda.hms.service;

import org.sda.hms.dto.AppointmentDTO;
import org.sda.hms.entities.Appointment;

import java.util.List;

public interface AppointmentService {

    void save(AppointmentDTO appointmentDTO);
    AppointmentDTO findById(Integer id);
    void update(AppointmentDTO appointmentDTO);
    void delete(Integer id);
    List<AppointmentDTO> findAll();

    //Update
}
