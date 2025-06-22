package dev.stegmaier.leetcode.services.LeetCodeQuestions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q3085MinimumDeletionServiceTest {

  private final Q3085MinimumDeletionService q3085MinimumDeletionService =
      new Q3085MinimumDeletionService();

  /*

  Example 1:

  Input: word = "aabcaba", k = 0

  Output: 3

  Explanation: We can make word 0-special by deleting 2 occurrences of "a" and 1 occurrence of "c". Therefore, word becomes equal to "baba" where freq('a') == freq('b') == 2.
  Example 2:

  Input: word = "dabdcbdcdcd", k = 2

  Output: 2

  Explanation: We can make word 2-special by deleting 1 occurrences of "a" and 1 occurrence of "d". Therefore, word becomes equal to "bdcbdcdcd" where freq('b') == 2, freq('c') == 3, and freq('d') == 4.
  Example 3:

  Input: word = "aaabaaa", k = 2

  Output: 1

  Explanation: We can make word 2-special by deleting 1 occurrence of "b". Therefore, word becomes equal to "aaaaaa" where each letter's frequency is now uniformly 6.

   */

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
