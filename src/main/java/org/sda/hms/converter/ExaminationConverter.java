package org.sda.hms.converter;

import org.sda.hms.dto.ExaminationDTO;
import org.sda.hms.entities.Employee;
import org.sda.hms.entities.Examination;
import org.sda.hms.entities.User;

public class ExaminationConverter {

    public static Examination toEntity(ExaminationDTO examinationDTO, User userId, Employee employeeId){

            Examination examination = new Examination();

            examination.setId(examinationDTO.getId());
            examination.setExaminationDate(examinationDTO.getExaminationDate());
            examination.setExaminationNotes(examinationDTO.getExaminationNotes());
            examination.setUserId(userId);
            examination.setEmployeeId(employeeId);


            return examination;
        }

        public static ExaminationDTO toDTO(Examination examination){

            ExaminationDTO examinationDTO = new ExaminationDTO();

            examinationDTO.setId(examination.getId());
            examinationDTO.setExaminationDate(examination.getExaminationDate());
            examinationDTO.setExaminationNotes(examination.getExaminationNotes());
            examinationDTO.setUserId(UserConverter.toDto(examination.getUserId()));
            examinationDTO.setEmployeeId(EmployeeConverter.toDto(examination.getEmployeeId()));
            return examinationDTO;
        }

        public static Examination toEntityForUpdate(Examination examination, ExaminationDTO examinationDTO){

            examination.setId(examinationDTO.getId());
            examination.setExaminationDate(examinationDTO.getExaminationDate());
            examination.setExaminationNotes(examinationDTO.getExaminationNotes());
            return examination;
        }
    }


