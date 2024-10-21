package dev.stegmaier.leetcode.controllers.questions;

import static dev.stegmaier.leetcode.utils.CorrelationIDUtil.getCorrelationId;
import static org.slf4j.LoggerFactory.getLogger;

import dev.stegmaier.leetcode.services.LeetCodeQuestions.Q1106BooleanParsingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/questions") // Base URI for all methods in this controller
public class Q1106ParsingABooleanExpressionController {

  private static final Logger log = getLogger(Q1106ParsingABooleanExpressionController.class);
  private final Q1106BooleanParsingService q1106BooleanParsingService;

  public Q1106ParsingABooleanExpressionController(
      Q1106BooleanParsingService q1106BooleanParsingService) {
    this.q1106BooleanParsingService = q1106BooleanParsingService;
  }

  // Display the question page for Leetcode Question #1106
  @GetMapping("/1106-Parsing-A-Boolean-Expression")
  public String question1106Page(HttpServletRequest request, HttpServletResponse response) {
    String clientIP = request.getRemoteAddr();
    String userAgent = request.getHeader("User-Agent");
    String correlationID = getCorrelationId(request);

    log.info(
        "question1106Page was requested by: {} Host: {} Correlation ID:{}",
        clientIP,
        userAgent,
        correlationID);

    response.setHeader("X-Correlation-ID", correlationID);

    return "questions/1106-Parsing-A-Boolean-Expression"; // Refers to addition.html template
  }

  // Display the question page for Leetcode Question #1106
  @PostMapping("/1106-Parsing-A-Boolean-Expression")
  public String handleQuestion1106Input(
      @RequestParam("expression") String expression,
      Model model,
      HttpServletRequest request,
      HttpServletResponse response) {
    String clientIP = request.getRemoteAddr();
    String userAgent = request.getHeader("User-Agent");
    String correlationID = getCorrelationId(request);

    log.info(
        "{} was submitted to question1106Page by: {} Host: {} Correlation ID:{}",
        expression,
        clientIP,
        userAgent,
        correlationID);

    try {
      boolean result =
          q1106BooleanParsingService.parseExpression(expression); // Using the injected MathService
      model.addAttribute("result", "Result: " + result);
      log.info(
          "{} returned from the Parsing Service. Correlation ID: {}", expression, correlationID);
    } catch (IllegalArgumentException e) {
      model.addAttribute("result", "Invalid input. Please enter a valid boolean expression.");
      log.error(
          "{} caused an error to occur in the Parsing Service. Correlation ID: {}",
          expression,
          correlationID);
    }

    response.setHeader("X-Correlation-ID", correlationID);

    return "questions/1106-Parsing-A-Boolean-Expression"; // Refers to addition.html template
  }
}
