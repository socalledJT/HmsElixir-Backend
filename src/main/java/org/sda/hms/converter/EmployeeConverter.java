package org.sda.hms.converter;

import org.sda.hms.dto.EmployeeDTO;
import org.sda.hms.entities.Department;
import org.sda.hms.entities.Employee;
import org.sda.hms.entities.User;

public class EmployeeConverter {
    public static EmployeeDTO toDto(Employee employee){
        EmployeeDTO employeeDto= new EmployeeDTO();

        employeeDto.setId(employee.getId());
        employeeDto.setUserId(UserConverter.toDto(employee.getUserId()));
        employeeDto.setDepartmentId(DepartmentConverter.toDTO(employee.getDepartmentId()));
        return employeeDto;
    }
    public static Employee toEntity(EmployeeDTO employeeDto, User userId, Department departmentId){
        Employee employee=new Employee();

        employee.setId(employeeDto.getId());
        employee.setUserId(userId);
        employee.setDepartmentId(departmentId);

        return employee;
    }




}
