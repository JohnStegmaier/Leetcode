package dev.stegmaier.leetcode.services.LeetCodeQuestions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q3085MinimumDeletionServiceTest {

  private final Q3085MinimumDeletionService q3085MinimumDeletionService =
      new Q3085MinimumDeletionService();

  @Test
  void shouldHandleBasicStringWithKValueAsZero() {
    String inputString = "aabcaba";
    int inputKValue = 0;

    int result = q3085MinimumDeletionService.getMinimumDeletions(inputString, inputKValue);

    assertEquals(3, result);
  }

  @Test
  void shouldHandleBasicStringWithKValueAsTwo() {
    String inputString = "dabdcbdcdcd";
    int inputKValue = 2;

    int result = q3085MinimumDeletionService.getMinimumDeletions(inputString, inputKValue);

    assertEquals(2, result);
  }

  @Test
  void shouldHandleStringWithManyRepeatingCharacters() {
    String inputString = "aaabaaa";
    int inputKValue = 2;

    int result = q3085MinimumDeletionService.getMinimumDeletions(inputString, inputKValue);

    assertEquals(1, result);
  }
}
