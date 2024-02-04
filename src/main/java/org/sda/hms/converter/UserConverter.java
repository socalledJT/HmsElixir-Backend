package org.sda.hms.converter;

import org.sda.hms.dto.UserDTO;
import org.sda.hms.entities.Department;
import org.sda.hms.entities.User;

public class UserConverter {

    public static UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFullName(user.getFullName());
        userDTO.setEmail(userDTO.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setDepartmentId(DepartmentConverter.toDTO(user.getDepartmentId()));

        return userDTO;
    }

    public static User toEntity(UserDTO userDTO, Department departmentId) {
        User user = new User();

        user.setId(userDTO.getId());
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setDepartmentId(departmentId);

        return user;
    }

    public static User toEntityForUpdate(UserDTO userDTO, User user) {

        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    public static User toEntityForUpdateAdmin(UserDTO userDTO, User user) {

        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setDepartmentId(DepartmentConverter.toEntity(userDTO.getDepartmentId()));

        return user;
    }
}
