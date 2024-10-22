package dev.stegmaier.leetcode.services.LeetCodeQuestions;

import static org.slf4j.LoggerFactory.getLogger;

import dev.stegmaier.leetcode.controllers.questions.Q1106ParsingABooleanExpressionController;
import java.util.Stack;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Q1106BooleanParsingService {

  private static final Logger log = getLogger(Q1106ParsingABooleanExpressionController.class);

  public boolean parseExpression(String expression) {
    log.debug("Parsing expression: {}", expression);

    Stack<Character> optr = new Stack<>();
    Stack<Character> operand = new Stack<>();
    int idx = 0;

    while (idx < expression.length()) {
      char ch = expression.charAt(idx);
      if (ch == '!' || ch == '&' || ch == '|') {
        optr.push(ch); // Push operators
      } else if (ch == 't' || ch == 'f') {
        operand.push(ch); // Push operands
      } else if (ch == '(') {
        operand.push(ch); // Push opening parentheses
      } else if (ch == ')') {
        evaluate(optr, operand); // Evaluate expression at closing parenthesis
      }
      idx++;
    }

    return operand.peek() == 't'; // Final result
  }

  void evaluate(Stack<Character> optr, Stack<Character> operand) {
    log.trace("evaluating: {}", optr);
    char op = optr.pop(); // Get the operator at the top and remove it
    boolean ans;

    if (op == '|') {
      ans = false; // For OR, initial value is false
      while (operand.peek() != '(') {
        ans |= (operand.pop() == 't');
      }
      pushResultToStack(operand, ans);
    } else if (op == '&') {
      ans = true; // For AND, initial value is true
      while (operand.peek() != '(') {
        ans &= (operand.pop() == 't');
      }
      pushResultToStack(operand, ans);
    } else if (op == '!') {
      ans = (operand.pop() == 't');
      ans = !ans; // Negate the value
      pushResultToStack(operand, ans);
    }
  }

  private static void pushResultToStack(Stack<Character> operand, boolean ans) {
    operand.pop(); // Pop the '('
    if (ans) {
      operand.push('t'); // Push true result
    } else {
      operand.push('f'); // Push false result
    }
  }
}
