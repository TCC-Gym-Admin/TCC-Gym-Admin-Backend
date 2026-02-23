package com.example.TCC_Gym_Admin.controllers;

import com.example.TCC_Gym_Admin.DTOs.EmployeeDTO;
import com.example.TCC_Gym_Admin.entities.Employee;
import com.example.TCC_Gym_Admin.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() {

        List<Employee> list = employeeService.findAll();
        List<EmployeeDTO> listDTO = list.stream().map(EmployeeDTO::new).toList();
        return ResponseEntity.ok(listDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable UUID id) {

        Employee obj = employeeService.findById(id);
        return ResponseEntity.ok(new EmployeeDTO(obj));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> save(@RequestBody EmployeeDTO objDTO) {
        Employee obj = employeeService.fromDTO(objDTO);
        obj = employeeService.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmployeeDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeDTO objDTO, @PathVariable UUID id) {
        Employee obj = employeeService.fromDTO(objDTO);
        obj.setId(id);
        employeeService.update(obj);
        return ResponseEntity.noContent().build();
    }
}
