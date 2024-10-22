package dev.stegmaier.leetcode.services.LeetCodeQuestions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q1106BooleanParsingServiceTest {

  private final Q1106BooleanParsingService parsingService = new Q1106BooleanParsingService();

  @Test
  void testExample1() {
    // Example 1
    String expression = "&(|(f))";
    boolean result = parsingService.parseExpression(expression);
    assertFalse(result, "Expected false for expression: " + expression);
  }

  @Test
  void testExample2() {
    // Example 2
    String expression = "|(f,f,f,t)";
    boolean result = parsingService.parseExpression(expression);
    assertTrue(result, "Expected true for expression: " + expression);
  }

  @Test
  void testExample3() {
    // Example 3
    String expression = "!(&(f,t))";
    boolean result = parsingService.parseExpression(expression);
    assertTrue(result, "Expected true for expression: " + expression);
  }

  @Test
  void shouldReturnTrueWhenOnlyTrueProvided() {
    // Here we are testing that it returns true when we only provide true as the value
    String expression = "t";
    boolean result = parsingService.parseExpression(expression);
    assertTrue(result, "Expected true for expression: " + expression);
  }

  @Test
  void shouldReturnFalseWhenOnlyFalseProvided() {
    // Here we are testing that it returns false when we only provide false as the value
    String expression = "f";
    boolean result = parsingService.parseExpression(expression);
    assertFalse(result, "Expected false for expression: " + expression);
  }

  @Test
  void shouldReturnTrueWithSimpleAndOperation() {
    String expression = "&(t,t)";
    boolean result = parsingService.parseExpression(expression);
    assertTrue(result, "Expected true for expression: " + expression);
  }

  @Test
  void shouldReturnFalseWithSimpleAndOperation() {
    String expression = "&(f,t)";
    boolean result = parsingService.parseExpression(expression);
    assertFalse(result, "Expected false for expression: " + expression);
  }

  @Test
  void shouldReturnFalseWithDoubleFalseAndOperation() {
    String expression = "&(f,f)";
    boolean result = parsingService.parseExpression(expression);
    assertFalse(result, "Expected false for expression: " + expression);
  }


}
