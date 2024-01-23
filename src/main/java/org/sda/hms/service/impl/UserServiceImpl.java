package org.sda.hms.service.impl;

import jakarta.transaction.Transactional;
import org.sda.hms.converter.UserConverter;
import org.sda.hms.dto.UserDTO;
import org.sda.hms.entities.User;
import org.sda.hms.repository.UserRepository;
import org.sda.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserDTO userDTO) {
        User user = UserConverter.toEntity(userDTO);

        userRepository.save(user);
    }

    @Override
    public void update(UserDTO userDTO) {

    }

    @Override
    public UserDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }
}
