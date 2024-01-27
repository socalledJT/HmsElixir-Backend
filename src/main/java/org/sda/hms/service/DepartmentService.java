package org.sda.hms.service;

import org.sda.hms.dto.DepartmentDTO;
import org.sda.hms.dto.UserDTO;

import java.util.List;

public interface DepartmentService {
    void save(DepartmentDTO departmentDTO);

    void update( DepartmentDTO departmentDTO);

    DepartmentDTO findById(Integer id);


    List<DepartmentDTO> findAll();

    void delete(DepartmentDTO departmentDTO);
}
