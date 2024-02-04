package org.sda.hms.service.impl;
import jakarta.transaction.Transactional;
import org.sda.hms.converter.AppointmentConverter;
import org.sda.hms.dto.AppointmentDTO;
import org.sda.hms.entities.Appointment;
import org.sda.hms.exeptions.NotAllowedException;
import org.sda.hms.exeptions.NotFoundException;
import org.sda.hms.repository.AppointmentRepo;
import org.sda.hms.repository.EmployeeRepository;
import org.sda.hms.repository.ExaminationRepository;
import org.sda.hms.repository.UserRepository;
import org.sda.hms.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional
public class AppointementServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public void save(AppointmentDTO appointmentDTO) {

        if (!appointmentDTO.getAppointmentDate().isBefore(LocalDateTime.now())
                && !appointmentDTO.getPatientNotes().isEmpty()
                && appointmentDTO.getPatientId() != null
                && appointmentDTO.getDoctorId() != null)
        {
            Appointment appointment = AppointmentConverter.toEntity(appointmentDTO, userRepository.findById(appointmentDTO.getPatientId().getId()).orElseThrow(),
                    employeeRepository.findById(appointmentDTO.getDoctorId().getId()).orElseThrow(),
                    examinationRepository.findById(appointmentDTO.getExaminationId().getId()).orElseThrow());
            appointmentRepo.save(appointment);

        }else {
            throw new NotAllowedException("Please, check the fields, some might be empty.");
        }
    }

    @Override
    public AppointmentDTO findById(Integer id) {

        return AppointmentConverter.toDTO(appointmentRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("This appointment does not exist!")));
    }

    @Override
    public void update(AppointmentDTO appointmentDTO) {


        if (!appointmentDTO.getAppointmentDate().isBefore(LocalDateTime.now())
                && !appointmentDTO.getPatientNotes().isEmpty()
                && appointmentDTO.getPatientId() != null
                && appointmentDTO.getDoctorId() != null)
        {
            Appointment appointment = appointmentRepo.findById(appointmentDTO.getId())
                    .orElseThrow(() -> new NotFoundException("Appointment with id " + appointmentDTO.getId() + "doesn't exist!"));
            appointmentRepo.save(AppointmentConverter.toEntityForUpdate(appointment, appointmentDTO));
        }else {
            throw new NotAllowedException("Sorry, you can not update your appointment.");
        }
    }

    @Override
    public void delete(AppointmentDTO appointmentDTO) {
        if(appointmentDTO.getId() != null) {
            Appointment appointment = appointmentRepo.findById(appointmentDTO.getId()).orElseThrow();
            appointmentRepo.delete(appointment);
        }else {
            throw new NotFoundException("Sorry, you can not delete this appointment, it does not exist.");

        }
    }

    @Override
    public List<AppointmentDTO> findAll() {

        return appointmentRepo.findAll().stream().map(AppointmentConverter::toDTO).toList();
    }
}

