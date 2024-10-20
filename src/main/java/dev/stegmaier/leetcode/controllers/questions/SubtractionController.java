package dev.stegmaier.leetcode.controllers.questions;

import dev.stegmaier.leetcode.services.MathService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/questions")  // Base URI for all methods in this controller
public class SubtractionController {

    private final MathService mathService;

    // Constructor injection of MathService
    public SubtractionController(MathService mathService) {
        this.mathService = mathService;
    }

    // Display the subtraction question page
    @GetMapping("/subtraction")
    public String subtractionPage(Model model) {
        model.addAttribute("description", "Enter two numbers separated by a comma, and this will subtract the second from the first. Example: 8,3 -> 5");
        return "questions/subtraction"; // Refers to subtraction.html template
    }

    // Handle subtraction form submission
    @PostMapping("/subtraction")
    public String handleSubtraction(@RequestParam("numbers") String numbers, Model model) {
        try {
            int result = mathService.subtract(numbers); // Using the injected MathService
            model.addAttribute("result", "Result: " + result);
        } catch (IllegalArgumentException e) {
            model.addAttribute("result", "Invalid input. Please enter two numbers separated by a comma.");
        }
        return "questions/subtraction";
    }
}
