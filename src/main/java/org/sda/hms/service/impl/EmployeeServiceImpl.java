package org.sda.hms.service.impl;

import org.sda.hms.dto.EmployeeDto;
import org.sda.hms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeService employeeService;


    @Override
    public void save(EmployeeDto employeeDto) {

    }

    @Override
    public EmployeeDto findById(Integer id) {
        return null;
    }
}
