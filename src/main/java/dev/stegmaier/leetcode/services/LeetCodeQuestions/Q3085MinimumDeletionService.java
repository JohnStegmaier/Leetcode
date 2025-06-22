package dev.stegmaier.leetcode.services.LeetCodeQuestions;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Q3085MinimumDeletionService {

  private static final Logger log = getLogger(Q3085MinimumDeletionService.class);

  public int getMinimumDeletions(String expression, int kValue) {
    checkExpressionMeetsRequirements(expression);

    return 0;
  }

  private void checkExpressionMeetsRequirements(String expression) {
    validateExpressionIsNotNull(expression);
    validateExpressionIsLargerThanOneCharacterLong(expression);
    validateExpressionIsSmallerThanOneHundredThousandCharacters(expression);
  }

  private void validateExpressionIsNotNull(String expression) {
    if (null == expression) {
      throw new NullPointerException("expression is somehow null");
    }
  }

  private void validateExpressionIsLargerThanOneCharacterLong(String expression) {
    if (expression.isEmpty()) {
      throw new IllegalArgumentException("expression length less than 1");
    }
  }

  private void validateExpressionIsSmallerThanOneHundredThousandCharacters(String expression) {
    if (expression.length() > 100000) {
      throw new IllegalArgumentException("expression length exceeds 10⁵");
    }
  }
}
