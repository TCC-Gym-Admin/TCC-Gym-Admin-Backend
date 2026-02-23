package com.example.TCC_Gym_Admin.repositories;

import com.example.TCC_Gym_Admin.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
