package org.sda.hms.service;

import org.sda.hms.dto.ExaminationDTO;
import org.sda.hms.dto.UserDTO;

import java.util.List;

public interface ExaminationService {

    void save(ExaminationDTO examinationDTO);

    void update(ExaminationDTO examinationDTO);

    UserDTO findById(Integer id);

    List<ExaminationDTO> findAll();

    void delete(ExaminationDTO examinationDTO);
}

