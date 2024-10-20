package dev.stegmaier.leetcode.controllers.questions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")  // Base URI for all methods in this controller
public class Q1106ParsingABooleanExpressionController {

    // Display the question page for Leetcode Question #1106
    @GetMapping("/1106-Parsing-A-Boolean-Expression")
    public String question1106Page() {
        return "questions/1106-Parsing-A-Boolean-Expression"; // Refers to addition.html template
    }
}
