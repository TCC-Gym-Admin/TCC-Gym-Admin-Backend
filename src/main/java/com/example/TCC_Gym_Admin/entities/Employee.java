package com.example.TCC_Gym_Admin.entities;

import com.example.TCC_Gym_Admin.entities.Enums.Position;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tb_employe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String fullName;
    private Integer age;
    private Position position;
    private String identificationNumber;
    private String address;
    private Double salary;
}
