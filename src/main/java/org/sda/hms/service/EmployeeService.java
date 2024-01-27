package org.sda.hms.service;

import org.sda.hms.dto.EmployeeDto;

public interface EmployeeService {
    void save(EmployeeDto employeeDto);
    void update(EmployeeDto employeeDto);
    EmployeeDto findById(Integer id);
    void delete(EmployeeDto employeeDto);
}
