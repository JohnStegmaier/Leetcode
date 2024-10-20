package dev.stegmaier.leetcode.services;

import org.springframework.stereotype.Component;

@Component
public class MathService {

    // Add two numbers provided as a comma-separated string
    public int add(String numbers) throws IllegalArgumentException {
        String[] splitNumbers = numbers.split(",");
        if (splitNumbers.length != 2) throw new IllegalArgumentException("Invalid input");

        int num1 = Integer.parseInt(splitNumbers[0].trim());
        int num2 = Integer.parseInt(splitNumbers[1].trim());
        return num1 + num2;
    }

    // Subtract two numbers provided as a comma-separated string
    public int subtract(String numbers) throws IllegalArgumentException {
        String[] splitNumbers = numbers.split(",");
        if (splitNumbers.length != 2) throw new IllegalArgumentException("Invalid input");

        int num1 = Integer.parseInt(splitNumbers[0].trim());
        int num2 = Integer.parseInt(splitNumbers[1].trim());
        return num1 - num2;
    }

}
