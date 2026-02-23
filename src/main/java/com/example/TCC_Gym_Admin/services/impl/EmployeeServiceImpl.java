package com.example.TCC_Gym_Admin.services.impl;

import com.example.TCC_Gym_Admin.DTOs.EmployeeDTO;
import com.example.TCC_Gym_Admin.entities.Employee;
import com.example.TCC_Gym_Admin.repositories.EmployeeRepository;
import com.example.TCC_Gym_Admin.services.EmployeeService;
import com.example.TCC_Gym_Admin.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(UUID id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        Employee newEmployee = findById(employee.getId());
        updateData(newEmployee, employee);
        return save(newEmployee);
    }

    @Override
    public void deleteById(UUID id) {
        findById(id);
        employeeRepository.deleteById(id);
    }

    private void updateData(Employee entity, Employee employee) {
        entity.setFullName(employee.getFullName());
        entity.setAge(employee.getAge());
        entity.setPosition(employee.getPosition());
        entity.setIdentificationNumber(employee.getIdentificationNumber());
        entity.setAddress(employee.getAddress());
        entity.setSalary(employee.getSalary());
    }

    public Employee fromDTO(EmployeeDTO obj) {
        return new Employee(
                obj.getId(),
                obj.getFullName(),
                obj.getAge(),
                obj.getPosition(),
                obj.getIdentificationNumber(),
                obj.getAddress(),
                obj.getSalary()
        );
    }
}
