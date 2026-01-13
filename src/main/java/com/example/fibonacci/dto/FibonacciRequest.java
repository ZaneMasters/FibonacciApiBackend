package com.example.fibonacci.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class FibonacciRequest {

    @NotBlank
    @Pattern(
        regexp = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$",
        message = "Formato de hora inválido. Use HH:mm:ss"
    )
    private String time;

    @NotBlank
    @Email(message = "Correo electrónico inválido")
    private String email;
}

