package dev.stegmaier.leetcode.services.LeetCodeQuestions;

import org.springframework.stereotype.Component;

@Component
public class Q1106BooleanParsingService {

    public boolean parseExpression(String expression) {
        return expression.equals("true");
    }
}
