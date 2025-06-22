package dev.stegmaier.leetcode.controllers.questions;

import static dev.stegmaier.leetcode.utils.CorrelationIDUtil.getCorrelationId;
import static org.slf4j.LoggerFactory.getLogger;

import dev.stegmaier.leetcode.services.LeetCodeQuestions.Q3085MinimumDeletionService;
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
public class Q3085MinimumDeletionstoMakeStringKSpecialController {

  private static final Logger log =
      getLogger(Q3085MinimumDeletionstoMakeStringKSpecialController.class);
  private final Q3085MinimumDeletionService q3085MinimumDeletionService;

  public Q3085MinimumDeletionstoMakeStringKSpecialController(
      Q3085MinimumDeletionService q3085MinimumDeletionService) {
    this.q3085MinimumDeletionService = q3085MinimumDeletionService;
  }

  // Display the question page for Leetcode Question #1106
  @GetMapping("/3085-Minimum-Deletions-To-Make-String-K-Special")
  public String question3085Page(HttpServletRequest request, HttpServletResponse response) {
    String clientIP = request.getRemoteAddr();
    String userAgent = request.getHeader("User-Agent");
    String correlationID = getCorrelationId(request);

    log.info(
        "question3085Page was requested by: {} Host: {} Correlation ID:{}",
        clientIP,
        userAgent,
        correlationID);

    response.setHeader("X-Correlation-ID", correlationID);

    return "questions/3085-Minimum-Deletions-To-Make-String-K-Special"; // Refers to addition.html
                                                                        // template
  }

  // Display the question page for Leetcode Question #1106
  @PostMapping("/3085-Minimum-Deletions-To-Make-String-K-Special")
  public String handleQuestion3085Input(
      @RequestParam("expression") String expression,
      @RequestParam("kValue") int kValue,
      Model model,
      HttpServletRequest request,
      HttpServletResponse response) {
    String clientIP = request.getRemoteAddr();
    String userAgent = request.getHeader("User-Agent");
    String correlationID = getCorrelationId(request);

    log.info(
        "{} with a value of k={} was submitted to question3085Page by: {} Host: {} Correlation ID:{}",
        expression,
        kValue,
        clientIP,
        userAgent,
        correlationID);

    try {
      int result =
          q3085MinimumDeletionService.getMinimumDeletions(
              expression, kValue); // Using the injected MathService
      model.addAttribute("result", "minimum number of deletions: " + result);
      log.info(
          "{} returned from the Deletion Service. Correlation ID: {}", expression, correlationID);
    } catch (IllegalArgumentException e) {
      model.addAttribute("result", "Invalid input. Please enter a valid input.");
      log.error(
          "{} with a value of k= {} caused an error to occur in the Deletion Service. Correlation ID: {}",
          expression,
          kValue,
          correlationID);
    }

    response.setHeader("X-Correlation-ID", correlationID);

    return "questions/3085-Minimum-Deletions-To-Make-String-K-Special"; // Refers to addition.html
                                                                        // template
  }
}
