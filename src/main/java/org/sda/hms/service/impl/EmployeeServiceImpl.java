package org.sda.hms.service.impl;

import org.sda.hms.converter.EmployeeConverter;
import org.sda.hms.dto.EmployeeDTO;
import org.sda.hms.entities.Employee;
import org.sda.hms.repository.EmployeeRepository;
import org.sda.hms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public void save(EmployeeDTO employeeDto) {
        if (!employeeRepository.findById(employeeDto.getId()).isEmpty()){
            throw new RuntimeException("Ky punonjes ekziston!");
        }
        Employee employee= EmployeeConverter.toEntity(employeeDto);
        employeeRepository.save(employee);
    }

    @Override
    public void update(EmployeeDTO employeeDto) {
        if (!employeeRepository.findById(employeeDto.getId()).isEmpty()){
            throw new RuntimeException("Ky punonjes ekziston!");
        }
        Employee employee=employeeRepository.findById(employeeDto.getId())
                .orElseThrow(() -> new  RuntimeException("Employee with id" + employeeDto.getId() + " doesn't exist!!!"));
        employeeRepository.save(EmployeeConverter.toEntity(employeeDto));

    }

    @Override
    public EmployeeDTO findById(Integer id) {
        //
        Optional<Employee> reurnedEmployee = employeeRepository.findById(id);
        if (reurnedEmployee.isPresent()) {
            return EmployeeConverter.toDto(reurnedEmployee.get());
        }
        else {
            throw new RuntimeException("Punonjesi nuk u gjet!");
        }
    }

    @Override
    public void delete(EmployeeDTO employeeDto) {
        Employee employee=EmployeeConverter.toEntity(employeeDto);

        employeeRepository.delete(employee);
    }

    @Override
    public List<EmployeeDTO> findAll() {

        return employeeRepository.findAll().stream().map(EmployeeConverter::toDto).toList();
    }

}
