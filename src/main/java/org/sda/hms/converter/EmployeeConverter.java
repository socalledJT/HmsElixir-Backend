package org.sda.hms.converter;

import org.sda.hms.dto.EmployeeDto;
import org.sda.hms.dto.UserDTO;
import org.sda.hms.entities.Employee;
import org.sda.hms.entities.User;

public class EmployeeConverter {
    public static EmployeeDto toDto(Employee employee){
        EmployeeDto employeeDto= new EmployeeDto();

        employeeDto.setId(employee.getId());
        employeeDto.setUserId(employee.getUserId());
        employeeDto.setDepartmentId(employee.getDepartmentId());
        return employeeDto;
    }
    public static Employee toEntity(EmployeeDto employeeDto){
        Employee employee=new Employee();

        employee.setId(employeeDto.getId());
        employee.setUserId(employeeDto.getUserId());
        employee.setDepartmentId(employeeDto.getDepartmentId());

        return employee;
    }




}
