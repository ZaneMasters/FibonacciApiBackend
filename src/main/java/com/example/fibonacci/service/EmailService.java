package com.example.fibonacci.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendFibonacciEmail(
            String to,
            String time,
            List<Long> series) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Prueba Técnica – Resultado Fibonacci");

        message.setText("""
            Hola,

            La serie Fibonacci fue generada exitosamente.

            Hora de ejecución: %s
            Serie Fibonacci: %s

            Saludos,
            Fibonacci API
            """.formatted(time, series));

        mailSender.send(message);
        log.info("Correo enviado a {}", to);
    }
}

