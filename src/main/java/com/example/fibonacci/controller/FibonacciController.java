package com.example.fibonacci.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fibonacci.dto.FibonacciRequest;
import com.example.fibonacci.dto.FibonacciResponse;
import com.example.fibonacci.model.FibonacciRecord;
import com.example.fibonacci.repository.FibonacciRepository;
import com.example.fibonacci.service.EmailService;
import com.example.fibonacci.service.FibonacciService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fibonacci")
@RequiredArgsConstructor
public class FibonacciController {

        private final FibonacciService service;
        private final FibonacciRepository repository;
        private final EmailService emailService;

        @PostMapping
        public ResponseEntity<FibonacciResponse> generate(
                        @Valid @RequestBody FibonacciRequest request) {

                List<Long> result = service.generate(request.getTime());

                FibonacciRecord record = new FibonacciRecord();
                record.setExecutionTime(request.getTime());
                record.setSeries(
                                result.stream()
                                                .map(String::valueOf)
                                                .collect(Collectors.joining(",")));
                repository.save(record);

                emailService.sendFibonacciEmail(
                                request.getEmail(),
                                request.getTime(),
                                result);

                String message = "La serie Fibonacci fue generada y enviada correctamente al correo "
                                + request.getEmail();

                return ResponseEntity.ok(
                                new FibonacciResponse(
                                                request.getTime(),
                                                result,
                                                message));
        }

        @GetMapping
        public List<FibonacciRecord> findAll() {
                return repository.findAll();
        }
}
