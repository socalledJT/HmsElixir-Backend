package org.sda.hms.controller;

import org.sda.hms.dto.AppointmentDTO;
import org.sda.hms.service.AppointmentService;
import org.sda.hms.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmantService;

    @PostMapping
    public void save(@RequestBody AppointmentDTO appointmentDTO){

        appointmantService.save(appointmentDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(appointmantService.findById(id));
    }

    @PutMapping
    public void update(@RequestBody AppointmentDTO appointmentDTO) {

        appointmantService.update(appointmentDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){

    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> findAll(){

        return ResponseEntity.ok(appointmantService.findAll());
    }
}
