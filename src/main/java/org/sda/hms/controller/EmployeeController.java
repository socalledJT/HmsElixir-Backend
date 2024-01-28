package org.sda.hms.controller;

import org.sda.hms.dto.EmployeeDTO;
import org.sda.hms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public void save(@RequestBody EmployeeDTO employeeDto){
        employeeService.save(employeeDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping
    public void update(@RequestBody EmployeeDTO employeeDto){
        employeeService.update(employeeDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        employeeService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() {

        return ResponseEntity.ok(employeeService.findAll());
    }
}
