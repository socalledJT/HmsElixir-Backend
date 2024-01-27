package org.sda.hms.service.impl;

import org.sda.hms.dto.EmployeeDto;
import org.sda.hms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeService employeeService;


    @Override
    public void save(EmployeeDto employeeDto) {

    }

    @Override
    public void update(EmployeeDto employeeDto) {

    }

    @Override
    public EmployeeDto findById(Integer id) {
        return null;
    }

    @Override
    public void delete(EmployeeDto employeeDto) {

    }

    @Override
    public List<EmployeeDto> findAll() {
        return null;
    }
}
