package com.example.TCC_Gym_Admin.DTOs;

import com.example.TCC_Gym_Admin.entities.Enums.Position;
import lombok.Data;

import java.util.UUID;

@Data
public class EmployeDTO {

    private UUID id;
    private String fullName;
    private Integer age;
    private Position position;
    private String identificationNumber;
    private String address;
    private Double salary;
}