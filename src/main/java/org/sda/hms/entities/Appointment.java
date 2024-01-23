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

}
