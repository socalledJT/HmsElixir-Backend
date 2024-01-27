package org.sda.hms.service.impl;

import jakarta.transaction.Transactional;
import org.sda.hms.converter.DepartmentConverter;
import org.sda.hms.converter.UserConverter;
import org.sda.hms.dto.DepartmentDTO;
import org.sda.hms.dto.UserDTO;
import org.sda.hms.entities.Department;
import org.sda.hms.entities.User;
import org.sda.hms.repository.DepartmentRepository;
import org.sda.hms.repository.UserRepository;
import org.sda.hms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public void save(DepartmentDTO departmentDTO) {

    }

    @Override
    public void update(DepartmentDTO departmentDTO) {

    }

    @Override
    public DepartmentDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<DepartmentDTO> findAll() {
        return null;
    }

    @Override
    public void delete(DepartmentDTO departmentDTO) {

    }
}
