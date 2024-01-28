package org.sda.hms.controller;

import org.sda.hms.dto.UserDTO;
import org.sda.hms.entities.enums.UserRole;
import org.sda.hms.exeptions.WrongUserException;
import org.sda.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void save(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
    }

    @PutMapping
    public void update(@RequestBody UserDTO userDTO) {
        userService.update(userDTO);
    }

    @PutMapping("/admin")
    public void updateAsAdmin(@RequestBody UserDTO userDTO) {
        if (userDTO.getRole() != UserRole.ADMIN) {
            throw new WrongUserException("You must be an admin complete this function");
        }

        userService.updateAsAdmin(userDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDTO> findByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody UserDTO userDTO) {
        userService.delete(userDTO);
    }
}
