package org.sda.hms.service.impl;

import jakarta.transaction.Transactional;
import org.sda.hms.converter.UserConverter;
import org.sda.hms.dto.AppointmentDTO;
import org.sda.hms.dto.EmployeeDTO;
import org.sda.hms.dto.ExaminationDTO;
import org.sda.hms.dto.UserDTO;
import org.sda.hms.entities.User;
import org.sda.hms.exeptions.InvalidDataException;
import org.sda.hms.repository.AppointmentRepo;
import org.sda.hms.repository.ExaminationRepository;
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
       if (userDTO.getFullName().isEmpty() ||
            userDTO.getFullName().isBlank() |
            userDTO.getEmail().isEmpty() ||
            userDTO.getPassword().isEmpty()) {
           throw new InvalidDataException("Invalid data input!");
       }

        User user = UserConverter.toEntity(userDTO);

        userRepository.save(user);
    }

    @Override
    public void update(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new RuntimeException("User with id " + userDTO.getId() + "doesn't exist!"));

        userRepository.save(UserConverter.toEntityForUpdate(userDTO, user));
    }

    @Override
    public UserDTO findById(Integer id) {
        return UserConverter.toDto(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("This user does not exist!")));
    }

    @Override
    public UserDTO findByEmail(String email) {
        return  UserConverter.toDto(userRepository.findByEmail(email));
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(UserConverter::toDto).toList();
    }

    @Override
    public void delete(UserDTO userDTO) {
        User user = UserConverter.toEntity(userDTO);

        userRepository.delete(user);
    }
}
