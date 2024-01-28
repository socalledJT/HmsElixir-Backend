package org.sda.hms.converter;

import org.sda.hms.dto.EmployeeDTO;
import org.sda.hms.entities.Employee;

public class EmployeeConverter {
    public static EmployeeDTO toDto(Employee employee){
        EmployeeDTO employeeDto= new EmployeeDTO();

        employeeDto.setId(employee.getId());
        employeeDto.setUserId(employee.getUserId());
        employeeDto.setDepartmentId(employee.getDepartmentId());
        return employeeDto;
    }
    public static Employee toEntity(EmployeeDTO employeeDto){
        Employee employee=new Employee();

        employee.setId(employeeDto.getId());
        employee.setUserId(employeeDto.getUserId());
        employee.setDepartmentId(employeeDto.getDepartmentId());

        return employee;
    }




}
