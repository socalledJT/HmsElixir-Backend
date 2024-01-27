package org.sda.hms.service.impl;

import org.sda.hms.converter.AppointmentConverter;
import org.sda.hms.dto.AppointmentDTO;
import org.sda.hms.entities.Appointment;
import org.sda.hms.repository.AppointmentRepo;
import org.sda.hms.service.AppointmantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppointementServiceImpl implements AppointmantService {

    @Autowired
    private AppointmentRepo appointmentRepo;


    @Override
    public void save(AppointmentDTO appointmentDTO) {
        Appointment appointment = AppointmentConverter.toEntity(appointmentDTO);

        appointmentRepo.save(appointment);
    }

    @Override
    public AppointmentDTO findById(Integer id) {
        return null;
    }

    @Override
    public void update(AppointmentDTO appointmentDTO) {
        System.out.println("Holaaaa");
    }

    @Override
    public void delete(Integer id) {
        System.out.println("Guapaaaa");
    }

    @Override
    public List<AppointmentDTO> findAll() {
        return null;
    }
}

