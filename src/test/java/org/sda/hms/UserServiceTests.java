package org.sda.hms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sda.hms.dto.UserDTO;
import org.sda.hms.entities.User;
import org.sda.hms.repository.UserRepository;
import org.sda.hms.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private UserDTO userToSave;

    private User user;

    @BeforeEach
    public void setUp() {
        initUserDto();
        initUser();
    }

}
