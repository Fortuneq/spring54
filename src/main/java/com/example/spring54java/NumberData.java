package com.example.spring54java;


import java.util.List;

public class NumberData {
    private List<Integer> numbers;
    private double average;

    public NumberData(List<Integer> numbers, double average) {
        this.numbers = numbers;
        this.average = average;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public double getAverage() {
        return average;
    }
}
