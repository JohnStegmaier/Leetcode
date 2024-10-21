package dev.stegmaier.leetcode.services.LeetCodeQuestions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

}