package dev.stegmaier.leetcode.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathServiceTest {

  private final MathService mathService = new MathService();

  @Test
  void addValidInput() {
    // Valid input test
    assertEquals(7, mathService.add("3,4"));
    assertEquals(0, mathService.add("-5,5"));
    assertEquals(-10, mathService.add("-5,-5"));
  }

  @Test
  void addInvalidInput() {
    // Test for invalid input cases
    assertThrows(IllegalArgumentException.class, () -> mathService.add("3"));
    assertThrows(IllegalArgumentException.class, () -> mathService.add("3,"));
    assertThrows(NumberFormatException.class, () -> mathService.add("a,b"));
  }

  @Test
  void subtractValidInput() {
    // Valid input test
    assertEquals(1, mathService.subtract("5,4"));
    assertEquals(-10, mathService.subtract("0,10"));
    assertEquals(5, mathService.subtract("-5,-10"));
  }

  @Test
  void subtractInvalidInput() {
    // Test for invalid input cases
    assertThrows(IllegalArgumentException.class, () -> mathService.subtract("3"));
    assertThrows(IllegalArgumentException.class, () -> mathService.subtract("3,"));
    assertThrows(NumberFormatException.class, () -> mathService.subtract("a,b"));
  }
}
