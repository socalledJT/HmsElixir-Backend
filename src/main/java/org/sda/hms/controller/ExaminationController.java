package org.sda.hms.controller;


import org.sda.hms.dto.EmployeeDto;
import org.sda.hms.dto.ExaminationDTO;
import org.sda.hms.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/examination")
    public class ExaminationController {
        @Autowired
        private ExaminationService examinationService;

        @PostMapping
        public void save(@RequestBody ExaminationDTO examinationDTO) {
            examinationService.save(examinationDTO);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ExaminationDTO> findById(@PathVariable Integer id) {
            return ResponseEntity.ok(examinationService.findById(id));
        }
        @PutMapping
        public void update (@RequestBody ExaminationDTO examinationDTO){
            examinationService.update(examinationDTO);

        }
        @GetMapping
        public ResponseEntity <List<ExaminationDTO>> findAll(){
            return ResponseEntity.ok(examinationService.findAll());
        }
    }



