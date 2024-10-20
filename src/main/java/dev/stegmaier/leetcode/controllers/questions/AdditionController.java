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
public class AdditionController {

    private final MathService mathService;

    // Constructor injection of MathService
    public AdditionController(MathService mathService) {
        this.mathService = mathService;
    }

    // Display the addition question page
    @GetMapping("/addition")
    public String additionPage(Model model) {
        model.addAttribute("description", "Enter two numbers separated by a comma, and this will add them together. Example: 4,5 -> 9");
        return "questions/addition"; // Refers to addition.html template
    }

    // Handle addition form submission
    @PostMapping("/addition")
    public String handleAddition(@RequestParam("numbers") String numbers, Model model) {
        try {
            int result = mathService.add(numbers); // Using the injected MathService
            model.addAttribute("result", "Result: " + result);
        } catch (IllegalArgumentException e) {
            model.addAttribute("result", "Invalid input. Please enter two numbers separated by a comma.");
        }
        return "questions/addition";
    }
}
