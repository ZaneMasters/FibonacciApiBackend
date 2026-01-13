package com.example.fibonacci.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.fibonacci.service.FibonacciService;

public class FibonacciServiceTest {

    private final FibonacciService service = new FibonacciService();

    @Test
    void shouldGenerateCorrectSeries() {
        List<Long> result = service.generate("15:49:08");

        List<Long> expected = List.of(
                390L, 241L, 149L, 92L, 57L,
                35L, 22L, 13L, 9L, 4L
        );

        assertEquals(expected, result);
    }

    @Test
    void shouldFailWhenSecondsIsZero() {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.generate("12:10:00"));
    }

}
