package com.example.TCC_Gym_Admin.DTOs;

import com.example.TCC_Gym_Admin.entities.Employee;
import com.example.TCC_Gym_Admin.entities.Enums.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private UUID id;
    private String fullName;
    private Integer age;
    private Position position;
    private String identificationNumber;
    private String address;
    private Double salary;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.fullName = employee.getFullName();
        this.age = employee.getAge();
        this.position = employee.getPosition();
        this.identificationNumber = employee.getIdentificationNumber();
        this.address = employee.getAddress();
        this.salary = employee.getSalary();
    }
}