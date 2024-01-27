package org.sda.hms.service.impl;

import org.sda.hms.converter.ExaminationConverter;
import org.sda.hms.dto.ExaminationDTO;
import org.sda.hms.entities.Examination;
import org.sda.hms.exeptions.NotFoundException;
import org.sda.hms.repository.ExaminationRepository;
import org.sda.hms.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service

public class ExaminationServiceImpl implements ExaminationService {
    @Autowired
    private ExaminationRepository examinationRepository;

    @Override
    public void save(ExaminationDTO examinationDTO) {
        Examination examination = ExaminationConverter.toEntity(examinationDTO);
        examinationRepository.save(examination);

    }

    @Override
    public ExaminationDTO findById(Integer id) {
        return ExaminationConverter.toDTO(examinationRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("This Examination does not exit!")));
    }
    @Override
    public void update (ExaminationDTO examinationDTO){
        Examination examination = examinationRepository.findById(examinationDTO.getId())
                .orElseThrow(() -> new NotFoundException("Examination doesn't exist"));
                examinationRepository.save(ExaminationConverter.toEntityForUpdate(examination, examinationDTO));
    }
    @Override
    public void delete(ExaminationDTO examinationDTO) {
        Examination examination = ExaminationConverter.toEntity(examinationDTO);
        examinationRepository.delete(examination);
    }

    @Override
    public List<ExaminationDTO> findAll() {
        return examinationRepository.findAll().stream().map(ExaminationConverter::toDTO).toList();

    }
}
