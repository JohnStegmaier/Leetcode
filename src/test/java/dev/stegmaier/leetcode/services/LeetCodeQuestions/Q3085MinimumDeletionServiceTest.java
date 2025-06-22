package dev.stegmaier.leetcode.services.LeetCodeQuestions;

import static dev.stegmaier.leetcode.constants.Q3085Constants.STRING_WITH_100000_CHARACTERS;
import static dev.stegmaier.leetcode.constants.Q3085Constants.STRING_WITH_100001_CHARACTERS;
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

  /*
  @Test
  void exceptionTesting() {
      MyException thrown = assertThrows(
             MyException.class,
             () -> myObject.doThing(),
             "Expected doThing() to throw, but it didn't"
      );

      assertTrue(thrown.getMessage().contains("Stuff"));
  }
   */
  @Test
  void shouldNotHandleStringOver100000CharactersLong() {
    String inputString = STRING_WITH_100001_CHARACTERS;
    int inputKValue = 0;

    IllegalArgumentException illegalArgumentException =
        assertThrows(
            IllegalArgumentException.class,
            () -> q3085MinimumDeletionService.getMinimumDeletions(inputString, inputKValue),
            "Expected q3085MinimumDeletionService to throw an exception when a string with more than 100,000 characters was provided");

    assertEquals(
        "expression length exceeds 10⁵",
        illegalArgumentException.getMessage(),
        "q3085MinimumDeletionService did not throw the correct exception message when a string with more than 100,000 characters was provided");
  }

  @Test
  void shouldNotHandleStringLessThanOneCharacterInLength() {
    String inputString = "";
    int inputKValue = 0;

    IllegalArgumentException illegalArgumentException =
        assertThrows(
            IllegalArgumentException.class,
            () -> q3085MinimumDeletionService.getMinimumDeletions(inputString, inputKValue),
            "Expected q3085MinimumDeletionService to throw an exception when a string smaller than 1 character was provided");

    assertEquals(
        "expression length less than 1",
        illegalArgumentException.getMessage(),
        "q3085MinimumDeletionService did not throw the correct exception message when a string smaller than 1 character was provided");
  }

  @Test
  void shouldNotHandleKValueOver100000() {
    String inputString = STRING_WITH_100000_CHARACTERS;
    int inputKValue = 100001;

    IllegalArgumentException illegalArgumentException =
        assertThrows(
            IllegalArgumentException.class,
            () -> q3085MinimumDeletionService.getMinimumDeletions(inputString, inputKValue),
            "Expected q3085MinimumDeletionService to throw an exception when a K value greater than 100,000 was provided");

    assertEquals(
        "K value provided is greater than 10⁵",
        illegalArgumentException.getMessage(),
        "q3085MinimumDeletionService did not throw the correct exception message when a K value greater than 100,000 was provided");
  }

  @Test
  void shouldNotHandleKValueLessThanZero() {
    String inputString = "aabbcc";
    int inputKValue = -1;

    IllegalArgumentException illegalArgumentException =
        assertThrows(
            IllegalArgumentException.class,
            () -> q3085MinimumDeletionService.getMinimumDeletions(inputString, inputKValue),
            "Expected q3085MinimumDeletionService to throw an exception when a K value less than zero was provided");

    assertEquals(
        "K value provided is less than 0",
        illegalArgumentException.getMessage(),
        "q3085MinimumDeletionService did not throw the correct exception message when a K value less than zero was provided");
  }

  @Test
  void shouldNotHandleNullString() {
    String inputString = null;
    int inputKValue = 0;

    NullPointerException nullPointerException =
        assertThrows(
            NullPointerException.class,
            () -> q3085MinimumDeletionService.getMinimumDeletions(inputString, inputKValue),
            "Expected q3085MinimumDeletionService to throw an exception when a null string was provided");

    assertEquals(
        "expression is somehow null",
        nullPointerException.getMessage(),
        "q3085MinimumDeletionService did not throw the correct exception message when a null string was provided");
  }

  @Test
  void shouldNotHandleNumericCharacters() {
    String inputString = "aabbcc12345abc";
    int inputKValue = 0;

    IllegalArgumentException illegalArgumentException =
        assertThrows(
            IllegalArgumentException.class,
            () -> q3085MinimumDeletionService.getMinimumDeletions(inputString, inputKValue),
            "Expected q3085MinimumDeletionService to throw an exception when an invalid string was provided");

    assertEquals(
        "Expression does not contain only lowercase letters",
        illegalArgumentException.getMessage(),
        "q3085MinimumDeletionService did not throw the correct exception message when an invalid string was provided");
  }
}
