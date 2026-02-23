package com.example.TCC_Gym_Admin.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandarError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}