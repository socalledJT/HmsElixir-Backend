package org.sda.hms.service;

import org.sda.hms.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    void save(EmployeeDTO employeeDto);
    void update(EmployeeDTO employeeDto);
    EmployeeDTO findById(Integer id);
    void delete(EmployeeDTO employeeDto);
    List<EmployeeDTO> findAll();
}
