package org.sda.hms.service;

import org.sda.hms.dto.ExaminationDTO;

import java.util.List;

public interface ExaminationService {

    void save(ExaminationDTO examinationDTO);

    void update(ExaminationDTO examinationDTO);

    ExaminationDTO findById(Integer id);



    void delete(ExaminationDTO examinationDTO);

    List<ExaminationDTO> findAll();
}
