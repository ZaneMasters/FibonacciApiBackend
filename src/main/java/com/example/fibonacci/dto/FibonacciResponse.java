package com.example.fibonacci.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FibonacciResponse {

    private String executionTime;
    private List<Long> series;
    private String message;
}
