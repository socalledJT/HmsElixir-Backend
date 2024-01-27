package org.sda.hms.controller;

import org.sda.hms.dto.AppointmentDTO;
import org.sda.hms.service.AppointmantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmantService appointmantService;

    @PostMapping
    public void save(@RequestBody AppointmentDTO appointmentDTO){

        appointmantService.save(appointmentDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(appointmantService.findById(id));
    }

    @PutMapping
    public void update(@RequestBody AppointmentDTO userDTO) {

        appointmantService.update(userDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){

        appointmantService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> findAll(){

        return ResponseEntity.ok(appointmantService.findAll());
    }
}