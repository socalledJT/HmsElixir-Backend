package org.sda.hms.service.impl;

import org.sda.hms.converter.AppointmentConverter;
import org.sda.hms.converter.UserConverter;
import org.sda.hms.dto.AppointmentDTO;
import org.sda.hms.entities.Appointment;
import org.sda.hms.entities.User;
import org.sda.hms.exeptions.AlreadyExistsException;
import org.sda.hms.exeptions.NotFoundException;
import org.sda.hms.repository.AppointmentRepo;
import org.sda.hms.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppointementServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo; //ciao


    @Override
    public void save(AppointmentDTO appointmentDTO) {

        Appointment appointment = AppointmentConverter.toEntity(appointmentDTO);
        appointmentRepo.save(appointment);
    }

    @Override
    public AppointmentDTO findById(Integer id) {

        return AppointmentConverter.toDTO(appointmentRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("This appointment does not exist!")));
    }

    @Override
    public void update(AppointmentDTO appointmentDTO) {

        Appointment appointment = appointmentRepo.findById(appointmentDTO.getId())
                .orElseThrow(() -> new NotFoundException("Appointment with id " + appointmentDTO.getId() + "doesn't exist!"));

        appointmentRepo.save(AppointmentConverter.toEntityForUpdate(appointment, appointmentDTO));
    }

    @Override
    public void delete(AppointmentDTO appointmentDTO) {

        Appointment appointment = AppointmentConverter.toEntity(appointmentDTO);

        appointmentRepo.delete(appointment);
    }

    @Override
    public List<AppointmentDTO> findAll() {

        return appointmentRepo.findAll().stream().map(AppointmentConverter::toDTO).toList();
    }
}

