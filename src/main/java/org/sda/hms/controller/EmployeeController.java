package org.sda.hms.controller;

import org.sda.hms.dto.EmployeeDto;
import org.sda.hms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public void save(@RequestBody EmployeeDto employeeDto){
        employeeService.save(employeeDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Integer id){
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping
    public void update(@RequestBody EmployeeDto employeeDto){
        employeeService.update(employeeDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable EmployeeDto id) { /////(Integer id)
        employeeService.delete(id);
    }


}
