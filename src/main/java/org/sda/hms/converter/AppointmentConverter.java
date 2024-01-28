package org.sda.hms.converter;

import org.sda.hms.dto.AppointmentDTO;
import org.sda.hms.entities.Appointment;
import org.sda.hms.entities.Employee;
import org.sda.hms.entities.Examination;
import org.sda.hms.entities.User;

public class AppointmentConverter {

    public static Appointment toEntity(AppointmentDTO appointmentDTO, User patiendID, Employee doctorID, Examination examinationID){

        Appointment appointment = new Appointment();

        appointment.setId(appointmentDTO.getId());
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setPrescription(appointmentDTO.getPrescription());
        appointment.setPatientNotes(appointmentDTO.getPatientNotes());
        appointment.setPatientId(patiendID);
        appointment.setDoctorId(doctorID);
        appointment.setExaminationId(examinationID);

        return appointment;
    }

    public static AppointmentDTO toDTO(Appointment appointment){

        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setAppointmentDate(appointment.getAppointmentDate());
        appointmentDTO.setPrescription(appointment.getPrescription());
        appointmentDTO.setPatientNotes(appointment.getPatientNotes());
        appointmentDTO.setPatientId(UserConverter.toDto(appointment.getPatientId()));
        appointmentDTO.setDoctorId(EmployeeConverter.toDto(appointment.getDoctorId()));
        appointmentDTO.setExaminationId(ExaminationConverter.toDTO(appointment.getExaminationId()));

        return appointmentDTO;
    }

    public static Appointment toEntityForUpdate(Appointment appointment,AppointmentDTO appointmentDTO){

        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setPatientNotes(appointmentDTO.getPatientNotes());

        return appointment;
    }
}
