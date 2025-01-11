package com.example.spring54java;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class NumberController {

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/generate")
    public String generateNumbers(@RequestParam int min,
                                  @RequestParam int max,
                                  Model model) {
        if (min > max) {
            model.addAttribute("error", "Минимум не должен быть больше максимума.");
            return "index";
        }

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            numbers.add(random.nextInt(max - min + 1) + min);
        }

        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        NumberData numberData = new NumberData(numbers, average);
        model.addAttribute("data", numberData);

        return "index";
    }
}
