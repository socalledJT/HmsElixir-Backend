package org.sda.hms.service;

import org.sda.hms.dto.UserDTO;

import java.util.List;

public interface UserService {

    void save(UserDTO userDTO);

    void update(UserDTO userDTO);

    UserDTO findById(Integer id);

//    UserDTO findByEmail(String email);
    List<UserDTO> findAll();
}
