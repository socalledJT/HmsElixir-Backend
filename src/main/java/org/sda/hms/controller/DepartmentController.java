package org.sda.hms.controller;

import org.sda.hms.dto.DepartmentDTO;
import org.sda.hms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public void save(@RequestBody DepartmentDTO departmentDTO){

        departmentService.save(departmentDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(departmentService.findById(id));
    }

    @PutMapping
    public void update(@RequestBody DepartmentDTO departmentDTO) {

        departmentService.update(departmentDTO);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        DepartmentDTO departmentDTO = departmentService.findById(id);
        departmentService.delete(departmentDTO);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll(){

        return ResponseEntity.ok(departmentService.findAll());
    }


}
