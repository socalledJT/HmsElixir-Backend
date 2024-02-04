package org.sda.hms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sda.hms.dto.DepartmentDTO;
import org.sda.hms.dto.UserDTO;
import org.sda.hms.entities.Department;
import org.sda.hms.entities.User;
import org.sda.hms.entities.enums.UserRole;
import org.sda.hms.repository.UserRepository;
import org.sda.hms.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private UserDTO userToSave;
    private DepartmentDTO departmentDTO;

    private User user;
    private Department department;

    @BeforeEach
    public void setUp() {
        initUserDto();
        initUser();
    }

    private void initUserDto() {
        userToSave = new UserDTO();

        userToSave.setFullName("Test User");
        userToSave.setEmail("testEmail@email.com");
        userToSave.setPassword("testPass");
        userToSave.setRole(UserRole.PATIENT);
        userToSave.setDepartmentId(departmentDTO);
    }

    private void initUser() {
        user = new User();

        user.setFullName("Test User");
        user.setEmail("testEmail@email.com");
        user.setPassword("testPass");
        user.setRole(UserRole.PATIENT);
        user.setDepartmentId(department);
    }

//    @Test
//    void saveUserTest_IsOK(){
//        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);
//        UserDTO userDTO = userService.save(userToSave);
//        Assertions.assertEquals(this.userToSave.getEmail(), userDTO.getEmail());
//        Assertions.assertEquals(this.userToSave.getFullName(), userDTO.getFullName());
//        Assertions.assertEquals(this.userToSave.getEmail(), userDTO.getEmail());
//        Assertions.assertEquals(this.userToSave.getRole(), userDTO.getRole());
//    }


}
