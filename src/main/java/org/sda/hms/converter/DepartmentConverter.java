package org.sda.hms.converter;

import org.sda.hms.dto.DepartmentDTO;
import org.sda.hms.entities.Department;

public class DepartmentConverter {
    public static Department toEntity(DepartmentDTO departmentDTO){
        Department department = new Department();

        department.setId(departmentDTO.getId());
        department.setDepName(departmentDTO.getDepName());


        return department;
    }

    public static DepartmentDTO toDTO(Department department){

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setId(department.getId());
        departmentDTO.setDepName(department.getDepName());


        return departmentDTO;
    }

    public static Department toEntityForUpdate(Department department,DepartmentDTO departmentDTO){

        department.setDepName(departmentDTO.getDepName());

        return department;
    }
}
