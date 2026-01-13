package com.example.fibonacci.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
@Slf4j
public class FibonacciService {

    public List<Long> generate(String time) {
        LocalTime localTime = LocalTime.parse(time);

        int minutes = localTime.getMinute();
        int seconds = localTime.getSecond();

        if (seconds <= 0) {
            throw new IllegalArgumentException("Los segundos deben ser mayores a cero");
        }

        long seed1 = minutes / 10;
        long seed2 = minutes % 10;

        List<Long> series = new ArrayList<>();
        series.add(seed1);
        series.add(seed2);

        for (int i = 0; i < seconds; i++) {
            int size = series.size();
            series.add(series.get(size - 1) + series.get(size - 2));
        }

        series.sort(Comparator.reverseOrder());
        return series;
    }
}



