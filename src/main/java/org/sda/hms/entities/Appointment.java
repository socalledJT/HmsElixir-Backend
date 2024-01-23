package org.sda.hms.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Table(name="appointment")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;

    @Column(name = "prescription")
    private String prescription;

    @Column(name = "patient_notes")
    private String patientNotes;

    @ManyToOne
    @JoinColumn(name = "patient_id" , referencedColumnName = "id")
    private User patientId;

    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private Employee doctorId;

    @ManyToOne
    @JoinColumn(name = "examination_id" , referencedColumnName = "id")
    private Examination examinationId;

    public Appointment() {
    }

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
