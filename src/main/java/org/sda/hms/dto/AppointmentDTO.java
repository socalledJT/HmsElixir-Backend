package org.sda.hms.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.sda.hms.entities.Employee;
import org.sda.hms.entities.Examination;
import org.sda.hms.entities.User;

import java.time.LocalDateTime;

public class AppointmentDTO {

    private Integer id;
    private LocalDateTime appointmentDate;
    private String prescription;
    private String patientNotes;
    private User patientId;
    private Employee doctorId;
    private Examination examinationId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getPatientNotes() {
        return patientNotes;
    }

    public void setPatientNotes(String patientNotes) {
        this.patientNotes = patientNotes;
    }

    public User getPatientId() {
        return patientId;
    }

    public void setPatientId(User patientId) {
        this.patientId = patientId;
    }

    public Employee getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Employee doctorId) {
        this.doctorId = doctorId;
    }

    public Examination getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(Examination examinationId) {
        this.examinationId = examinationId;
    }
}
