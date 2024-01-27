package org.sda.hms.converter;

import org.sda.hms.dto.ExaminationDTO;
import org.sda.hms.entities.Examination;

public class ExaminationConverter {

    public static Examination toEntity(ExaminationDTO examinationDTO){

            Examination examination = new Examination();

            examination.setId(examinationDTO.getId());
            examination.setExaminationDate(examinationDTO.getExaminationDate());
            examination.setExaminationNotes(examinationDTO.getExaminationNotes());
            examination.setUserId(examinationDTO.getUserId());
            examination.setEmployeeId(examinationDTO.getEmployeeId());


            return examination;
        }

        public static ExaminationDTO toDTO(Examination examination){

            ExaminationDTO examinationDTO = new ExaminationDTO();

            examinationDTO.setId(examination.getId());
            examinationDTO.setExaminationDate(examination.getExaminationDate());
            examinationDTO.setExaminationNotes(examination.getExaminationNotes());
            examinationDTO.setUserId(examination.getUserId());
            examinationDTO.setEmployeeId(examination.getEmployeeId());
            return examinationDTO;
        }

        public static Examination toEntityForUpdate(Examination examination,ExaminationDTO examinationDTO){

            examination.setId(examinationDTO.getId());
            examination.setExaminationDate(examinationDTO.getExaminationDate());
            examination.setExaminationNotes(examinationDTO.getExaminationNotes());
            examination.setUserId(examinationDTO.getUserId());
            examination.setEmployeeId(examinationDTO.getEmployeeId());
            return examination;
        }
    }


