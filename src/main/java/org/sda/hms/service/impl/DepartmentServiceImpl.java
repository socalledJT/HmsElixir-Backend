package org.sda.hms.service.impl;

import jakarta.transaction.Transactional;
import org.sda.hms.converter.DepartmentConverter;
import org.sda.hms.dto.DepartmentDTO;
import org.sda.hms.entities.Department;
import org.sda.hms.repository.DepartmentRepository;
import org.sda.hms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void save(DepartmentDTO departmentDTO) {
        Department department = DepartmentConverter.toEntity(departmentDTO);
        departmentRepository.save(department);

    }

    @Override
    public DepartmentDTO findById(Integer id) {
        return DepartmentConverter.toDTO(departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("This Department does not exist!")));

    }
    @Override
    public void update(DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(departmentDTO.getId())
                .orElseThrow(() -> new RuntimeException("Department with id " + departmentDTO.getId() + "doesn't exist!"));

        departmentRepository.save(DepartmentConverter.toEntityForUpdate(department, departmentDTO));
    }
    @Override
    public void delete(DepartmentDTO departmentDTO) {
        Department department = DepartmentConverter.toEntity(departmentDTO);
        departmentRepository.delete(department);
    }
    @Override
    public List<DepartmentDTO> findAll() {

            return departmentRepository.findAll().stream().map(DepartmentConverter::toDTO).toList();

    }



    }



