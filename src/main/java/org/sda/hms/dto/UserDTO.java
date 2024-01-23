package org.sda.hms.dto;

import lombok.Data;
import org.sda.hms.entities.enums.UserRole;

@Data
public class UserDTO {

    private Integer id;

    private String fullName;

    private String email;

    private String password;

    private UserRole role;

    private String department;
}
