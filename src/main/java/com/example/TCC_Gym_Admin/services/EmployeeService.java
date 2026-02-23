package com.example.TCC_Gym_Admin.services;

import com.example.TCC_Gym_Admin.DTOs.EmployeeDTO;
import com.example.TCC_Gym_Admin.entities.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(UUID id);

    Employee save(Employee employee);

    Employee update(Employee employee);

    void deleteById(UUID id);

    Employee fromDTO(EmployeeDTO obj);
}
