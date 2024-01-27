package org.sda.hms.service;

import org.sda.hms.dto.DepartmentDTO;
import org.sda.hms.dto.UserDTO;

import java.util.List;

public interface DepartmentService {
    void save(DepartmentDTO departmentDTO);
    DepartmentDTO findById(Integer id);

    void update( DepartmentDTO departmentDTO);

    void delete(DepartmentDTO departmentDTO);
    List<DepartmentDTO> findAll();
}
