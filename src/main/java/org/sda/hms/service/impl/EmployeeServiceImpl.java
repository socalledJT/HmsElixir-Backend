package org.sda.hms.service.impl;

import org.sda.hms.converter.EmployeeConverter;
import org.sda.hms.dto.EmployeeDTO;
import org.sda.hms.entities.Employee;
import org.sda.hms.exeptions.AlreadyExistsException;
import org.sda.hms.exeptions.NotFoundException;
import org.sda.hms.repository.DepartmentRepository;
import org.sda.hms.repository.EmployeeRepository;
import org.sda.hms.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public void save(EmployeeDTO employeeDto) {
        if (employeeRepository.findById(employeeDto.getId()).isPresent()){
            throw new AlreadyExistsException("This employee exist!");
        }
        Employee employee= EmployeeConverter.toEntity(employeeDto,
                userRepository.findById(employeeDto.getUserId().getId()).orElseThrow(),
                departmentRepository.findById(employeeDto.getDepartmentId().getId()).orElseThrow());

        employeeRepository.save(employee);
    }

    @Override
    public void update(EmployeeDTO employeeDto) {
        if (!employeeRepository.findById(employeeDto.getId()).isEmpty()){
            throw new AlreadyExistsException("This employee alredy exist!");
        }
        Employee employee= employeeRepository.findById(employeeDto.getId())
                .orElseThrow(() -> new  RuntimeException("Employee with id" + employeeDto.getId() + " doesn't exist!!!"));

        employeeRepository.save(EmployeeConverter.toEntity(employeeDto,
                userRepository.findById(employeeDto.getUserId().getId()).orElseThrow(),
                departmentRepository.findById(employeeDto.getDepartmentId().getId()).orElseThrow()));
    }

    @Override
    public EmployeeDTO findById(Integer id) {

        Optional<Employee> reurnedEmployee = employeeRepository.findById(id);
        if (reurnedEmployee.isPresent()) {
            return EmployeeConverter.toDto(reurnedEmployee.get());
        }
        else {
            throw new NotFoundException("Employee not found!");
        }
    }

    @Override
    public void delete(EmployeeDTO employeeDto) {
        Employee employee = employeeRepository.findById(employeeDto.getId())
                .orElseThrow(() -> new NotFoundException("This employee Doesn't exist!"));

        employeeRepository.delete(employee);
    }

    @Override
    public List<EmployeeDTO> findAll() {

        return employeeRepository.findAll().stream().map(EmployeeConverter::toDto).toList();
    }

}
