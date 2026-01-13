package com.example.fibonacci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fibonacci.model.FibonacciRecord;

@Repository
public interface FibonacciRepository
        extends JpaRepository<FibonacciRecord, Long> {
}
