package org.sda.hms.converter;

import org.sda.hms.dto.AppointmentDTO;
import org.sda.hms.entities.Appointment;

public class AppointmentConverter {

    public static Appointment toEntity(AppointmentDTO appointmentDTO){

        Appointment appointment = new Appointment();

        appointment.setId(appointmentDTO.getId());
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setPrescription(appointmentDTO.getPrescription());
        appointment.setPatientNotes(appointmentDTO.getPatientNotes());
        appointment.setPatientId(appointmentDTO.getPatientId());
        appointment.setDoctorId(appointmentDTO.getDoctorId());
        appointment.setExaminationId(appointmentDTO.getExaminationId());

        return appointment;
    }

    public static AppointmentDTO toDTO(Appointment appointment){

        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setAppointmentDate(appointment.getAppointmentDate());
        appointmentDTO.setPrescription(appointment.getPrescription());
        appointmentDTO.setPatientNotes(appointment.getPatientNotes());
        appointmentDTO.setPatientId(appointment.getPatientId());
        appointmentDTO.setDoctorId(appointment.getDoctorId());
        appointmentDTO.setExaminationId(appointment.getExaminationId());

        return appointmentDTO;
    }

    public static Appointment toEntityForUpdate(Appointment appointment,AppointmentDTO appointmentDTO){

        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setPatientNotes(appointmentDTO.getPatientNotes());

        return appointment;
    }
}
