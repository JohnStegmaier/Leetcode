package dev.stegmaier.leetcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

  @GetMapping
  public String home(Model model) {
    model.addAttribute("welcomeMessage", "Welcome to the Home Page!");
    return "home"; // Maps to home.html
  }
}
